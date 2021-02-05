package com.example.demo.shoppingcart;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {

	ArrayList<Shoppingcart> getShoppingcartById(String id);

	void insertCart(Shoppingcart cart);
	
}
