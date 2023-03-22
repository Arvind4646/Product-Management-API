package com.example.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Brand;
import com.example.models.Product;
import com.example.repositories.BrandRepository;
import com.example.services.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired private BrandRepository brepo;
	
	@Override
	public Brand addBrandDetails(Brand brand) {
		return brepo.save(brand);
	}

	public List<Brand> getBrandList() {
		return brepo.findAll();
	}

	public Brand getBrandDetailsById(int id) {
		return brepo.findById(id).orElse(null);
	}

	public List<Brand> getBrandDetailsByName(String name) {
		return brepo.findByBrandname(name);
	}
	
	public List<Product> getProductDetailsByBrandId(int bid) {
		return brepo.findProductByBrandId(bid);
	}

	public List<Product> getProductDetailsByBrandname(String brandname) {
		return brepo.findProductByBrandname(brandname);
	}

	public void deleteProductByBrandId(int bid) {
		brepo.deleteProductByBrandId(bid);
	}

	public Brand updateBrand(Brand brand) {
		return brepo.save(brand);
	}

	public void deleteAll() {
		brepo.deleteAll();
	}

//	public void deleteBrandById(int bid) {
//		brepo.deleteById(bid);
//	}
//
//	public void deleteBrandByBrandname(String brandname) {
//		brepo.deleteBrandByBrandname(brandname);
//	}



}
