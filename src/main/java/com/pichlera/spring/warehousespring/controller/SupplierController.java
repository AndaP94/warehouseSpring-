package com.pichlera.spring.warehousespring.controller;


import com.pichlera.spring.warehousespring.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupplierController {

    ISupplierRepository iSupplierRepository;


    @Autowired
    public SupplierController(ISupplierRepository iSupplierRepository) {
        this.iSupplierRepository = iSupplierRepository;
    }

//    @RequestMapping("add-article")
//    public String addSupplier(Model model){
//        model.addAttribute("supplier", iSupplierRepository.findAll());
//        return "add-article";
//    }


}
