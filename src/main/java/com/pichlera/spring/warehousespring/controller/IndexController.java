package com.pichlera.spring.warehousespring.controller;

import com.pichlera.spring.warehousespring.repository.IArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    IArticleRepository iArticleRepository;

    public IndexController(IArticleRepository iArticleRepository) {
        this.iArticleRepository = iArticleRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getArticle(Model model){
        model.addAttribute("article", iArticleRepository.findAll());

        return "index";
    }

    @RequestMapping("/header")
    public String searchArticle(Model model){
        model.addAttribute("form");

        return "index";

    }



}
