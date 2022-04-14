package com.devlomo.sbms.svc.products.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devlomo.sbms.svc.products.app.model.entity.Product;
import com.devlomo.sbms.svc.products.app.service.IProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sbms/products")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping()
	public List<Product> getAll() throws Exception{
		try {
			return (List<Product>) productService.findAll();
		} catch (Exception e) {
			log.warn("error while retrieving all products");
			throw new Exception(e);
		}
	}
	
	@GetMapping("/find")
	public Product getById(@RequestBody Long id) throws Exception {
		try {
			return productService.findById(id);
		} catch (Exception e) {
			log.warn("error while retrieving all products");
			throw new Exception(e);
		}
	}

}
