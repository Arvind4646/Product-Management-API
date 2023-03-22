package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.models.Color;
import com.example.models.Product;

public interface ColorRepository extends JpaRepository<Color, Integer> {
	
	List<Color> findByColor(String name);
	
	@Query("from Product p where color.cid=:id")
	List<Product> findProductByColorId(@Param("id") Integer cid);
	
	@Query("from Product p join Color c on p.color.cid=c.cid where c.color=:name")
	List<Product> findProductByColor(@Param("name") String color);

//	@Transactional
//	@Modifying
//	@Query("delete from Color where color=:c")
//	void deleteColorByName(@Param("c") String color);
}
