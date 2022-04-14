package com.devlomo.sbms.svc.products.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devlomo.sbms.svc.products.app.model.entity.Product;
import com.devlomo.sbms.svc.products.app.model.entity.Response;
import com.devlomo.sbms.svc.products.app.service.IProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sbms/products")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping()
	public ResponseEntity<Object> getAll() throws Exception{
		List<Product> products = new ArrayList<>();
		try {
			products = productService.findAll();
			return Response.generate("find all", HttpStatus.OK, products);
		} catch (Exception e) {
			log.warn("error while retrieving all products");
			return Response.generate("error", HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@GetMapping("/find")
	public ResponseEntity<Object> getById(@RequestBody Long id) throws Exception {
		Product product = new Product();
		try {
			product = productService.findById(id);
			return Response.generate("find", HttpStatus.OK, product);
		} catch (Exception e) {
			log.warn("error while retrieving all products");
			return Response.generate("error", HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
