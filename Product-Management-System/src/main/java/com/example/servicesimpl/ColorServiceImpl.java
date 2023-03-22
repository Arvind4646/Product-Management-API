package com.example.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Color;
import com.example.models.Product;
import com.example.repositories.ColorRepository;
import com.example.services.ColorService;

@Service
public class ColorServiceImpl implements ColorService {

	@Autowired private ColorRepository crepo;
	
	public Color addColor(Color color) {
		return crepo.save(color);
	}
	
	public List<Color> getColorList() {
		return crepo.findAll();
	}

	public Color getColorDetailsById(int cid) {
		return crepo.findById(cid).orElse(null);
	}

	public List<Color> getColorDetailsByName(String color) {
		return crepo.findByColor(color);
	}

	public List<Product> getProductDetailsByColorId(int cid) {
		return crepo.findProductByColorId(cid);
	}
	
	public List<Product> getProductDetailsByColor(String color) {
		return crepo.findProductByColor(color);
	}

	public Color updateColor(Color color) {
		return crepo.save(color);
	}

	public void deleteAll() {
		crepo.deleteAll();
		
	}

//	public void deleteColorById(int cid) {
//		crepo.deleteById(cid);
//	}
//
//	public void deleteColorByName(String color) {
//		crepo.deleteColorByName(color);
//	}

}
