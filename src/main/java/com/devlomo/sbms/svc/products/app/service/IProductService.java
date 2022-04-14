package com.devlomo.sbms.svc.products.app.service;

import java.util.List;

import com.devlomo.sbms.svc.products.app.model.entity.Product;

public interface IProductService {
	
	public List<Product> findAll() throws Exception;
	
	public Product findById(Long Id) throws Exception;

}
