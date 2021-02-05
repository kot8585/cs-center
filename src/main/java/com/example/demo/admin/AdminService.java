package com.example.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	@Autowired
	private AdminMapper mapper;

	public Admin getAdmin(String id) {
		return mapper.selectAdmin(id);
	}
	
	
}
