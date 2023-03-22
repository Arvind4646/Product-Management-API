package com.example.servicesimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Product;
import com.example.repositories.ProductRepository;
import com.example.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired private ProductRepository prepo;

	public Product addProduct(Product product) {
		return prepo.save(product);
	}
	
	public Product getProductDetailsById(int id) {
		return prepo.findById(id).orElse(null);
	}

	public List<Product> getProductList() {
		return prepo.findAll();
	}

	public List<Product> getProductDetailsByName(String name) {
		return prepo.findByName(name);
	}

	public List<Product> getProductDetailsByPrize(int prize) {
		return prepo.findByPrize(prize);
	}
	
	public List<Product> getProductDetailsByNameAndPrize(String name, int prize) {
		return prepo.findByNameAndPrize(name, prize);
	}

	public List<Product> getProductDetailsByPrizeRange(int prize1, int prize2) {
		return prepo.findByPrizeBetween(prize1,prize2);
	}

	public List<Product> getProductDetailsLessThanPrize(int prize) {
		return prepo.findByPrizeLessThan(prize);
	}

	public List<Product> getProductDetailsLessThanAndEqualToPrize(int prize) {
		return prepo.findByPrizeLessThanEqual(prize);
	}

	public List<Product> getProductDetailsAboveThanPrize(int prize) {
		return prepo.findByPrizeGreaterThan(prize);
	}

	public List<Product> getProductDetailsAboveThanAndEqualToPrize(int prize) {
		return prepo.findByPrizeGreaterThanEqual(prize);
	}

	public List<Product> getProductDetailsInAscendingOrder() {
		return prepo.findByOrderByPrize();
	}

	public List<Product> getProductDetailsInDescendingOrder() {
		return prepo.findByOrderByPrizeDesc();
	}

	public List<Product> getProductDetailsInProductNameAscendingOrder() {
		return prepo.findByOrderByName();
	}

	public List<Product> getProductDetailsInProductNameDescendingOrder() {
		return prepo.findByOrderByNameDesc();
	}

	public List<Product> getProductDetailsByProductNameInAscendingOrder(String name) {
		return prepo.findByNameOrderByPrize(name);
}

	public List<Product> getProductDetailsByProductNameInDescendingOrder(String name) {
		return prepo.findByNameOrderByPrizeDesc(name);
	}

	public List<Product> getProductDetailsByNameStartingWith(String name) {
		return prepo.findByNameStartingWith(name);
	}
	
	public List<Product> getProductDetailsByNameEndWith(String name) {
		return prepo.findByNameEndingWith(name);
	}

	public List<Product> getProductDetailsByNameContaining(String name) {
		return prepo.findByNameContaining(name);
	}

	public void deleteProductById(int pid) {
		prepo.deleteById(pid);
	}

	public void deleteProductByName(String name) {
		prepo.deleteByName(name);
		
	}

	public Product updateProduct(Product product) {
		return prepo.save(product);
	}

	public void deleteAll() {
		prepo.deleteAll();
		
	}
	
}
