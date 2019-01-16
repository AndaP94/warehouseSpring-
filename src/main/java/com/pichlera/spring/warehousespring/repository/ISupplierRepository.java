package com.pichlera.spring.warehousespring.repository;

import com.pichlera.spring.warehousespring.model.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplierRepository extends CrudRepository<Supplier, Long> {
}
