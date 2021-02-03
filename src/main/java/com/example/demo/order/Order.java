package com.example.demo.order;

import java.sql.Date;

public class Order {
	private int num;
	private String m_id;
	private int p_num;
	private int cost;
	private Date o_date;
	private int state;
	
	public Order() {
		super();
	}

	public Order(int num, String m_id, int p_num, int cost, Date o_date, int state) {
		super();
		this.num = num;
		this.m_id = m_id;
		this.p_num = p_num;
		this.cost = cost;
		this.o_date = o_date;
		this.state = state;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Order [num=" + num + ", m_id=" + m_id + ", p_num=" + p_num + ", cost=" + cost + ", o_date=" + o_date
				+ ", state=" + state + "]";
	}

	
	
}
