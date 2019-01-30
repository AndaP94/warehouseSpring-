package com.pichlera.spring.warehousespring.controller;

import com.pichlera.spring.warehousespring.model.Article;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public interface IArticleController {

    @RequestMapping("/add-article")
    public String addArticle(Model model);

    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable("id") long id, Model model);


    @PostMapping("/add-article")
    public String submitArticle(Model model, @ModelAttribute Article article );

    @RequestMapping(value = "s", method = RequestMethod.GET)
    public String showArticleById(@RequestParam (value = "s", required = false) Long search, Model model);

    @GetMapping("/update-article/{id}")
    public String updateArticle(@PathVariable("id") long id, Model model);
}
