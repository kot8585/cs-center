package com.example.demo.order;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

	ArrayList<Order> getMyOrderListById(String id);
	
}
