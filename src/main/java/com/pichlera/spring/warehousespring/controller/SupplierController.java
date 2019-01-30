package com.pichlera.spring.warehousespring.controller;

import com.pichlera.spring.warehousespring.model.Supplier;
import com.pichlera.spring.warehousespring.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class SupplierController implements ISupplierController{

    ISupplierRepository iSupplierRepository;


    @Autowired
    public SupplierController(ISupplierRepository iSupplierRepository) {
        this.iSupplierRepository = iSupplierRepository;
    }


    @Override
    public String addSupplier(Model model) {
        return null;
    }

    @Override
    public String deleteSupplier(long id, Model model) {
        return null;
    }

    @Override
    public String submitSupplier(Model model, Supplier supplier) {
        return null;
    }
}