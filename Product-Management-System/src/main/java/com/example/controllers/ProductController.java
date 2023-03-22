package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Product;
import com.example.services.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired private ProductService pservice;
	
	@PostMapping("add")
	public ResponseEntity<Product> productAdd(@RequestBody Product product)
	{
		Product p=pservice.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	@GetMapping("list")
	public ResponseEntity<List<Product>> productList()
	{
		List<Product> list=pservice.getProductList();
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@DeleteMapping("deletebyid")
	public ResponseEntity<Product> deleteProductById(@RequestParam int pid)
	{
		Product p = pservice.getProductDetailsById(pid);
		if(p==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		pservice.deleteProductById(pid);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	@DeleteMapping("deletebyname")
	public ResponseEntity<List<Product>> deleteProductByName(@RequestParam String name)
	{
		List<Product> p = pservice.getProductDetailsByName(name);
		if(p.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		pservice.deleteProductByName(name);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	@DeleteMapping("deleteall")
	public ResponseEntity<List<Product>> deleteAll()
	{
		List<Product> list= pservice.getProductList();
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		pservice.deleteAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PutMapping("updateproductbyid/{pid}")
	public ResponseEntity<Product> updateProductById(@RequestBody Product product,@PathVariable int pid)
	{
		Product pexsist = pservice.getProductDetailsById(pid);
		if(pexsist!=null)
		{
			product.setPid(pid);
			Product p=pservice.updateProduct(product);
			return ResponseEntity.status(HttpStatus.OK).body(p);
		}
		Product p=pservice.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
}
