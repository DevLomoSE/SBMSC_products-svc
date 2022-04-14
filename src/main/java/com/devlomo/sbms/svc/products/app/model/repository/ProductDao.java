package com.devlomo.sbms.svc.products.app.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.devlomo.sbms.svc.products.app.model.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long> {

}
