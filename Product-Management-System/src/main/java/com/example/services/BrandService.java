package com.example.services;

import java.util.List;

import com.example.models.Brand;
import com.example.models.Product;

public interface BrandService {

	Brand addBrandDetails(Brand brand);

	List<Brand> getBrandList();

	Brand getBrandDetailsById(int id);

	List<Brand> getBrandDetailsByName(String name);
	
	List<Product> getProductDetailsByBrandId(int bid);

	List<Product> getProductDetailsByBrandname(String brandname);

	void deleteProductByBrandId(int bid);

	Brand updateBrand(Brand brand);

	void deleteAll();

//	void deleteBrandById(int bid);
//
//	void deleteBrandByBrandname(String brandname);


}
