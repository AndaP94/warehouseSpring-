package com.pichlera.spring.warehousespring.logic;

import com.pichlera.spring.warehousespring.model.Supplier;
import com.pichlera.spring.warehousespring.repository.ISupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SupplierLogic implements ISupplierLogic {

    ISupplierRepository iSupplierRepository;


    @Autowired
    public SupplierLogic(ISupplierRepository iSupplierRepository) {
        this.iSupplierRepository = iSupplierRepository;
    }

    @Override
    public Optional<Supplier> findSupplierById(Long id) {
        return iSupplierRepository.findById(id);
    }

    @Override
    public Iterable<Supplier> findAllSupplier() {
        return iSupplierRepository.findAll();
    }
}
