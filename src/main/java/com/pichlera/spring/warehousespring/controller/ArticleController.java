package com.pichlera.spring.warehousespring.controller;

import com.pichlera.spring.warehousespring.model.Article;
import com.pichlera.spring.warehousespring.repository.IArticleRepository;
import com.pichlera.spring.warehousespring.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@Controller
public class ArticleController
{
    private IArticleRepository iArticleRepository;
    private ISupplierRepository iSupplierRepository;

    @Autowired
    public ArticleController(IArticleRepository iArticleRepository, ISupplierRepository iSupplierRepository) {

        this.iArticleRepository = iArticleRepository;
        this.iSupplierRepository = iSupplierRepository;
    }


    @RequestMapping("/add-article")
    public String addArticle(Model model){
        model.addAttribute("article", new Article());
        model.addAttribute("supplier", iSupplierRepository.findAll());

        return "add-article";

    }

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable("id") long id, Model model){
        Article article =  iArticleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid article Id:" + id));
        iArticleRepository.delete(article);
        model.addAttribute("article", iArticleRepository.findAll());
        return "index";

    }

    @PostMapping("/add-article")
    public String submitArticle(Model model, @ModelAttribute Article article ){
        iArticleRepository.save(article);
        model.addAttribute("supplier", iSupplierRepository.findById(article.getSupplier().getSupplierId()));
        return "result";
    }

    @RequestMapping(value = "s", method = RequestMethod.GET)
    public String showArticleById(@RequestParam (value = "s", required = false) Long search, Model model){

        model.addAttribute("article", iArticleRepository.findAllById(Collections.singleton(search)));
        return "article";
    }


}
