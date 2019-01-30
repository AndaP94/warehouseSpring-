package com.pichlera.spring.warehousespring.logic;

import com.pichlera.spring.warehousespring.model.Supplier;

import java.util.Optional;

public interface ISupplierLogic {

    public Optional<Supplier> findSupplierById(Long id);

    public Iterable<Supplier> findAllSupplier();
}
