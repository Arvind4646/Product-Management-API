package com.example.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByName(String name);
	
	List<Product> findByPrize(Integer prize);
	
	List<Product> findByNameAndPrize(String name,Integer prize);
//  Inside working of findByNameOrPrize method	
//	@Query("from Product where name=:na and prize=:p")
//	List<Product> findByNameOrPrize(@Param("na") String name,@Param("p") int prize);
	
	List<Product> findByPrizeBetween(Integer prize1,Integer prize2);
//	Inside working of findByPrizeBetween method
//	@Query("from Product where prize between :p1 and :p2")
//	List<Product> findByPrizeBetween(@Param("p1") int prize1,@Param("p2") int prize2);
	
	List<Product> findByPrizeLessThan(Integer prize);
//  Inside working of findByPrizeLessThan method
//	@Query("from Product where prize<:p")
//	List<Product> findByPrizeLessThan(@Param("p") int prize);
	
	List<Product> findByPrizeLessThanEqual(Integer prize);
	
	List<Product> findByPrizeGreaterThan(Integer prize);
	
	List<Product> findByPrizeGreaterThanEqual(Integer prize);
	
	List<Product> findByOrderByPrize();

	List<Product> findByOrderByPrizeDesc();
	
	List<Product> findByOrderByName();
	
	List<Product> findByOrderByNameDesc();
	
	List<Product> findByNameOrderByPrize(String name);
	
	List<Product> findByNameOrderByPrizeDesc(String name);
	
	List<Product> findByNameStartingWith(String name);
	
	List<Product> findByNameEndingWith(String name);

	List<Product> findByNameContaining(String name);

	@Transactional
	@Modifying
	@Query("delete from Product where name=:na")
	void deleteByName(@Param("na") String name);


	
}
