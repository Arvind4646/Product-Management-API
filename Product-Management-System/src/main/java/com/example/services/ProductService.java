package com.example.services;

import java.util.List;

import com.example.models.Product;


public interface ProductService {

	Product addProduct(Product product);

	Product getProductDetailsById(int id);

	List<Product> getProductList();

	List<Product> getProductDetailsByName(String name);

	List<Product> getProductDetailsByPrize(int prize);

	List<Product> getProductDetailsByNameAndPrize(String name, int prize);

	List<Product> getProductDetailsByPrizeRange(int prize1, int prize2);

	List<Product> getProductDetailsLessThanPrize(int prize);

	List<Product> getProductDetailsLessThanAndEqualToPrize(int prize);

	List<Product> getProductDetailsAboveThanPrize(int prize);

	List<Product> getProductDetailsAboveThanAndEqualToPrize(int prize);

	List<Product> getProductDetailsInAscendingOrder();

	List<Product> getProductDetailsInDescendingOrder();

	List<Product> getProductDetailsInProductNameAscendingOrder();

	List<Product> getProductDetailsInProductNameDescendingOrder();

	List<Product> getProductDetailsByProductNameInAscendingOrder(String name);

	List<Product> getProductDetailsByProductNameInDescendingOrder(String name);

	List<Product> getProductDetailsByNameStartingWith(String name);
	
	List<Product> getProductDetailsByNameEndWith(String name);

	List<Product> getProductDetailsByNameContaining(String name);

	void deleteProductById(int pid);

	void deleteProductByName(String name);

	Product updateProduct(Product product);

	void deleteAll();


	
}
