package com.pichlera.spring.warehousespring.controller;

import com.pichlera.spring.warehousespring.logic.IArticleLogic;
import com.pichlera.spring.warehousespring.logic.ISupplierLogic;
import com.pichlera.spring.warehousespring.model.Article;
import com.pichlera.spring.warehousespring.repository.IArticleRepository;
import com.pichlera.spring.warehousespring.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.OnError;
import java.util.Collections;
import java.util.Optional;

@SuppressWarnings("ALL")
@Controller
public class ArticleController implements IArticleController
{
    private IArticleLogic iArticleLogic;
    private ISupplierLogic iSupplierLogic;


    @Autowired
    public ArticleController(IArticleLogic iArticleLogic, ISupplierLogic iSupplierLogic) {
        this.iArticleLogic = iArticleLogic;
        this.iSupplierLogic = iSupplierLogic;
    }

    @RequestMapping("/add-article")
    public String addArticle(Model model){
        model.addAttribute("article", new Article());
        model.addAttribute("supplier", iSupplierLogic.findAllSupplier());

        return "add-article";

    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable("id") long id, Model model){
        Article article =  iArticleLogic.findArticleById(id).orElseThrow(() -> new IllegalArgumentException("Invalid article Id:" + id));
        iArticleLogic.deleteArticle(article);
        model.addAttribute("article", iArticleLogic.findAllArticle());
        return "index";

    }

    @GetMapping("/update-article/{id}")
    public String updateArticle(@PathVariable("id") long id, Model model){
        Article article = iArticleLogic.findArticleById(id).get();
        model.addAttribute("supplier", iSupplierLogic.findAllSupplier());
        model.addAttribute("article", article);
        return "update";
    }

    @PostMapping("/updateAndSave")
    public String updateAndSaveArticle(Model model, @ModelAttribute Article article){
        Article article1 = iArticleLogic.findArticleById(article.getArticleId()).get();
        article1.setArticleName(article.getArticleName());
        article1.setPackageUnit(article.getPackageUnit());
        article1.setPrice(article.getPrice());
        article1.setSupplier(article.getSupplier());
        iArticleLogic.saveArticle(article1);
        model.addAttribute("supplier", iSupplierLogic.findSupplierById(article1.getSupplier().getSupplierId()));

        return "result";
    }

    @PostMapping("/add-article")
    public String submitArticle(Model model, @ModelAttribute Article article ){
        iArticleLogic.saveArticle(article);
        model.addAttribute("supplier", iSupplierLogic.findSupplierById(article.getSupplier().getSupplierId()));
        return "result";
    }

    @RequestMapping(value = "s", method = RequestMethod.GET)
    public String showArticleById(@RequestParam (value = "s", required = false) Long search, Model model){

        model.addAttribute("article", iArticleLogic.findAllArticleById(search));
        return "article";
    }



}
