package com.pichlera.spring.warehousespring.controller;

import com.pichlera.spring.warehousespring.model.Supplier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public interface ISupplierController {

    @RequestMapping("/add-supplier")
    public String addSupplier(Model model);

    @GetMapping("/delete-supplier/{id}")
    public String deleteSupplier(@PathVariable("id") long id, Model model);


    @PostMapping("/add-supplier")
    public String submitSupplier(Model model, @ModelAttribute Supplier supplier );
}
