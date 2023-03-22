package com.example.services;

import java.util.List;

import com.example.models.Color;
import com.example.models.Product;

public interface ColorService {

	Color addColor(Color color);

	List<Color> getColorList();

	Color getColorDetailsById(int cid);

	List<Color> getColorDetailsByName(String color);

	List<Product> getProductDetailsByColorId(int cid);

	List<Product> getProductDetailsByColor(String color);

	Color updateColor(Color color);

	void deleteAll();

//	void deleteColorById(int cid);
//
//	void deleteColorByName(String color);

}
