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

import com.example.models.Brand;
import com.example.models.Product;
import com.example.services.BrandService;

@RestController
@RequestMapping("brand")
public class BrandController {

	@Autowired private BrandService bservice;
	
	@PostMapping("add")
	public ResponseEntity<Brand> brandAdd(@RequestBody Brand brand)
	{
		Brand b=bservice.addBrandDetails(brand);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}
	
	@GetMapping("list")
	public ResponseEntity<List<Brand>> BrandList()
	{
		List<Brand> list=bservice.getBrandList();
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("search/byid")
	public ResponseEntity<Brand> BrandSearchById(@RequestParam int bid)
	{
		Brand b=bservice.getBrandDetailsById(bid);
		if(b==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(b);
	}
	
	@GetMapping("search/byname")
	public ResponseEntity<List<Brand>> brandSearchByName(@RequestParam String brandname)
	{
		List<Brand> b=bservice.getBrandDetailsByName(brandname);
		if(b.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(b);
	}
	
	@GetMapping("search/productbybrandid/{bid}")
	public ResponseEntity<List<Product>> findProductByBrandId(@PathVariable int bid)
	{
		List<Product> list = bservice.getProductDetailsByBrandId(bid);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("search/productbybrandname/{brandname}")
	public ResponseEntity<List<Product>> findProductByBrandname(@PathVariable String brandname)
	{
		List<Product> list = bservice.getProductDetailsByBrandname(brandname);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@DeleteMapping("deleteproductbybrandid/{bid}")
	public ResponseEntity<List<Product>> deleteProductByBrandId(@PathVariable int bid)
	{
		List<Product> p = bservice.getProductDetailsByBrandId(bid);
		if(p.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		bservice.deleteProductByBrandId(bid);
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	@DeleteMapping("deleteall")
	public ResponseEntity<List<Brand>> deleteAll()
	{
		List<Brand> list= bservice.getBrandList();
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		bservice.deleteAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PutMapping("updatebrandbyid/{bid}")
	public ResponseEntity<Brand> updateBrandById(@RequestBody Brand brand,@PathVariable int bid)
	{
		Brand bexsist = bservice.getBrandDetailsById(bid);
		if(bexsist!=null)
		{
			brand.setBid(bid);
			Brand b=bservice.updateBrand(brand);
			return ResponseEntity.status(HttpStatus.OK).body(b);
		}
		Brand b=bservice.addBrandDetails(brand);
		return ResponseEntity.status(HttpStatus.CREATED).body(b);
	}
	
//	@DeleteMapping("deletebrandbyid/{bid}")
//	public ResponseEntity<Brand> deleteBrandById(@PathVariable int bid)
//	{
//		Brand b = bservice.getBrandDetailsById(bid);
//		if(b==null)
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		bservice.deleteBrandById(bid);
//		return ResponseEntity.status(HttpStatus.OK).body(b);
//	}
//	
//	@DeleteMapping("deletebrandbybrandname/{brandname}")
//	public ResponseEntity<List<Brand>> deleteBrandByBrandname(@PathVariable String brandname)
//	{
//		List<Brand> blist = bservice.getBrandDetailsByName(brandname);
//		if(blist.isEmpty())
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		bservice.deleteBrandByBrandname(brandname);
//		return ResponseEntity.status(HttpStatus.OK).body(blist);
//	}
}
