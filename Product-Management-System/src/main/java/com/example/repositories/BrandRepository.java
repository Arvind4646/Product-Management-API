package com.example.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.models.Brand;
import com.example.models.Product;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	
	List<Brand> findByBrandname(String name);
	
	@Query("from Product p where brand.bid=:id")
	List<Product> findProductByBrandId(@Param("id") Integer bid);
	
	@Query("from Product p join Brand b on p.brand.bid=b.bid where b.brandname=:name")
	List<Product> findProductByBrandname(@Param("name") String brandname);

	@Transactional
	@Modifying
	@Query("delete from Product where brand.bid=:id")
	void deleteProductByBrandId(@Param("id") Integer bid);
	
//	@Transactional
//	@Modifying
//	@Query("delete from Brand where brandname=:name")
//	void deleteBrandByBrandname(@Param("name") String brandnamem);
}
