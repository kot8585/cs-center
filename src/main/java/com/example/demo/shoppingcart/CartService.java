package com.example.demo.shoppingcart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Autowired
	private CartMapper mapper;
	
	public ArrayList<Shoppingcart> getShoppingcartById(String id) {
		return mapper.getShoppingcartById(id);
	}
	
	
}
