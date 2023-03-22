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

import com.example.models.Color;
import com.example.models.Product;
import com.example.services.ColorService;

@RestController
@RequestMapping("color")
public class ColorController {

	@Autowired private ColorService cservice;
	
	@PostMapping("add")
	public ResponseEntity<Color> colorAdd(@RequestBody Color color)
	{
		Color c=cservice.addColor(color);
		return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}
	
	@GetMapping("list")
	public ResponseEntity<List<Color>> getColorList()
	{
		List<Color> list=cservice.getColorList();
			if(list.isEmpty())
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("search/byid")
	public ResponseEntity<Color> colorSearchById(@RequestParam int cid)
	{
		Color c=cservice.getColorDetailsById(cid);
			if(c==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(c);
	}
	
	@GetMapping("search/byname")
	public ResponseEntity<List<Color>> colorSearchByName(@RequestParam String color)
	{
		List<Color> c=cservice.getColorDetailsByName(color);
			if(c.isEmpty())
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(c);
	}
	
	@GetMapping("search/productbycolorid/{cid}")
	public ResponseEntity<List<Product>> findProductByColorId(@PathVariable int cid)
	{
		List<Product> list = cservice.getProductDetailsByColorId(cid);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("search/productbycolor/{color}")
	public ResponseEntity<List<Product>> findProductByColor(@PathVariable String color)
	{
		List<Product> list = cservice.getProductDetailsByColor(color);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@DeleteMapping("deleteall")
	public ResponseEntity<List<Color>> deleteAll()
	{
		List<Color> list= cservice.getColorList();
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		cservice.deleteAll();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@PutMapping("updatecolorbyid/{cid}")
	public ResponseEntity<Color> updateColorById(@RequestBody Color color,@PathVariable int cid)
	{
		Color cexsist = cservice.getColorDetailsById(cid);
		if(cexsist!=null)
		{
			color.setCid(cid);
			Color c=cservice.updateColor(color);
			return ResponseEntity.status(HttpStatus.OK).body(c);
		}
		Color c=cservice.addColor(color);
		return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}
	
//	@DeleteMapping("deletecolorbyid/{cid}")
//	public ResponseEntity<Color> deleteolorById(@PathVariable int cid)
//	{
//		Color c = cservice.getColorDetailsById(cid);
//		if(c==null)
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		cservice.deleteColorById(cid);
//		return ResponseEntity.status(HttpStatus.OK).body(c);
//	}
//	
//	@DeleteMapping("deletecolorbycolorname/{color}")
//	public ResponseEntity<List<Color>> deleteColorByColorname(@PathVariable String color)
//	{
//		List<Color> clist = cservice.getColorDetailsByName(color);
//		if(clist.isEmpty())
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		cservice.deleteColorByName(color);
//		return ResponseEntity.status(HttpStatus.OK).body(clist);
//	}
}
