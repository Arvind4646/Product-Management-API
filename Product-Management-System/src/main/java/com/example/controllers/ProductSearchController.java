package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Product;
import com.example.services.ProductService;

@RestController
@RequestMapping("product/search")
public class ProductSearchController {
	
	@Autowired private ProductService pservice;
	
	@GetMapping("byid")
	public ResponseEntity<Product> productSearchById(@RequestParam int pid)
	{
		Product p=pservice.getProductDetailsById(pid);
		if(p==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	@GetMapping("byname")
	public ResponseEntity<List<Product>> productSearchByName(@RequestParam String name)
	{
		List<Product> list=pservice.getProductDetailsByName(name);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("byprize/{prize}")
	public ResponseEntity<List<Product>> getProductDetailsByPrize(@PathVariable int prize)
	{
		List<Product> prizelist=pservice.getProductDetailsByPrize(prize);
		if(prizelist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(prizelist);
	}
	
	@GetMapping("bynameandprize/{name}/{prize}")
	public ResponseEntity<List<Product>> getProductDetailsByPrize(@PathVariable String name,@PathVariable int prize)
	{
		List<Product> list=pservice.getProductDetailsByNameAndPrize(name,prize);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("byprizebetween/{prize1}/{prize2}")
	public ResponseEntity<List<Product>> getProductDetailsByPrizeRange(@PathVariable() int prize1,@PathVariable int prize2)
	{
		List<Product> list=pservice.getProductDetailsByPrizeRange(prize1,prize2);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("prizebelow/{prize}")
	public ResponseEntity<List<Product>> getProductDetailsBelowPrize(@PathVariable int prize)
	{
		List<Product> prizelist=pservice.getProductDetailsLessThanPrize(prize);
		if(prizelist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(prizelist);
	}
	
	@GetMapping("prizebelowandequalto/{prize}")
	public ResponseEntity<List<Product>> getProductDetailsBelowAndEqualToPrize(@PathVariable int prize)
	{
		List<Product> prizelist=pservice.getProductDetailsLessThanAndEqualToPrize(prize);
		if(prizelist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(prizelist);
	}
	
	@GetMapping("prizeabove/{prize}")
	public ResponseEntity<List<Product>> getProductDetailsAbovePrize(@PathVariable int prize)
	{
		List<Product> prizelist=pservice.getProductDetailsAboveThanPrize(prize);
		if(prizelist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(prizelist);
	}
	
	@GetMapping("prizeaboveandequalto/{prize}")
	public ResponseEntity<List<Product>> getProductDetailsAboveAndEqualToPrize(@PathVariable int prize)
	{
		List<Product> prizelist=pservice.getProductDetailsAboveThanAndEqualToPrize(prize);
		if(prizelist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(prizelist);
	}

	@GetMapping("prizeinascendingorder")
	public ResponseEntity<List<Product>> getProductDetailsInPriceAscendingOrder()
	{
		List<Product> list = pservice.getProductDetailsInAscendingOrder();
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("prizeindescendingorder")
	public ResponseEntity<List<Product>> getProductDetailsInPriceDescendingOrder()
	{
		List<Product> list = pservice.getProductDetailsInDescendingOrder();
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("productnameinascendingorder")
	public ResponseEntity<List<Product>> getProductDetailsInProductNameAscendingOrder()
	{
		List<Product> list = pservice.getProductDetailsInProductNameAscendingOrder();
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("productnameindescendingorder")
	public ResponseEntity<List<Product>> getProductDetailsInProductNameDescendingOrder()
	{
		List<Product> list = pservice.getProductDetailsInProductNameDescendingOrder();
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("productdetailsbynameinprizeascendingorder/{name}")
	public ResponseEntity<List<Product>> getProductDetailsByProductNameInAscendingOrder(@PathVariable String name)
	{
		List<Product> list = pservice.getProductDetailsByProductNameInAscendingOrder(name);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("productdetailsbynameinprizedescendingorder/{name}")
	public ResponseEntity<List<Product>> getProductDetailsByProductNameInDescendingOrder(@PathVariable String name)
	{
		List<Product> list = pservice.getProductDetailsByProductNameInDescendingOrder(name);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("productdetailsbynamestartingwith/{name}")
	public ResponseEntity<List<Product>> getProductDetailsByNameStartingWith(@PathVariable String name)
	{
		List<Product> list = pservice.getProductDetailsByNameStartingWith(name);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("productdetailsbynameendwith/{name}")
	public ResponseEntity<List<Product>> getProductDetailsByNameEndWith(@PathVariable String name)
	{
		List<Product> list = pservice.getProductDetailsByNameEndWith(name);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("productdetailsbynamecontaining/{name}")
	public ResponseEntity<List<Product>> getProductDetailsByNameContaining(@PathVariable String name)
	{
		List<Product> list = pservice.getProductDetailsByNameContaining(name);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
}
