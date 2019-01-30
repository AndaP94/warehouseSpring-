package com.pichlera.spring.warehousespring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public interface IIndexController {

    @RequestMapping({"", "/", "/index"})
    public String getArticle(Model model);

    @RequestMapping("/header")
    public String searchArticle(Model model);
}
