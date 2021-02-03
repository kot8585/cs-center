package com.example.demo.order;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderMapper mapper;

	public ArrayList<Order> getMyOrderListById(String id) {
		// TODO Auto-generated method stub
		return mapper.getMyOrderListById(id);
	}
	
	
}