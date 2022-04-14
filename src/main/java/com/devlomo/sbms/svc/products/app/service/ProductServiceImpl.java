package com.devlomo.sbms.svc.products.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devlomo.sbms.svc.products.app.model.entity.Product;
import com.devlomo.sbms.svc.products.app.model.repository.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired 
	private ProductDao productDao;

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() throws Exception {
		try {
			log.info("finding all products");
			return (List<Product>) productDao.findAll();
		}catch (Exception e) {
			log.error("error while retrieving the products, error: {}", e.getStackTrace().toString());
			throw new Exception(e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Product findById(Long Id) throws Exception {
		try {
			if(Id != null) {
				return productDao.findById(Id).orElse(null);
			}else {
				return null;
			}
		} catch (Exception e) {
			log.error("error while retrieving the product by Id: {}, error: {}", Id, e.getStackTrace());
			throw new Exception(e);
		}
	}

}
