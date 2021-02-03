package com.example.demo.product;

import org.springframework.web.multipart.MultipartFile;

public class Product {

	private int num;
	private String name;
	private String maker;
	private String price;
	private String origin;
	private String material;
	private String quantity;
	private String imgPath;
	private Float location_x;
	private Float location_y;
	private Float location_z;
	private int category1_id;
	private int category2_id;
	private int category3_id;
	private int event_num;
	private MultipartFile file1;
	private MultipartFile file2;
	private MultipartFile file3;
	public Product() {
		super();
	}
	public Product(int num, String name, String maker, String price, String origin, String material, String quantity,
			String imgPath, Float location_x, Float location_y, Float location_z, int category1_id, int category2_id,
			int category3_id, int event_num, MultipartFile file1, MultipartFile file2, MultipartFile file3) {
		super();
		this.num = num;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.origin = origin;
		this.material = material;
		this.quantity = quantity;
		this.imgPath = imgPath;
		this.location_x = location_x;
		this.location_y = location_y;
		this.location_z = location_z;
		this.category1_id = category1_id;
		this.category2_id = category2_id;
		this.category3_id = category3_id;
		this.event_num = event_num;
		this.file1 = file1;
		this.file2 = file2;
		this.file3 = file3;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Float getLocation_x() {
		return location_x;
	}
	public void setLocation_x(Float location_x) {
		this.location_x = location_x;
	}
	public Float getLocation_y() {
		return location_y;
	}
	public void setLocation_y(Float location_y) {
		this.location_y = location_y;
	}
	public Float getLocation_z() {
		return location_z;
	}
	public void setLocation_z(Float location_z) {
		this.location_z = location_z;
	}
	public int getCategory1_id() {
		return category1_id;
	}
	public void setCategory1_id(int category1_id) {
		this.category1_id = category1_id;
	}
	public int getCategory2_id() {
		return category2_id;
	}
	public void setCategory2_id(int category2_id) {
		this.category2_id = category2_id;
	}
	public int getCategory3_id() {
		return category3_id;
	}
	public void setCategory3_id(int category3_id) {
		this.category3_id = category3_id;
	}
	public int getEvent_num() {
		return event_num;
	}
	public void setEvent_num(int event_num) {
		this.event_num = event_num;
	}
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public MultipartFile getFile2() {
		return file2;
	}
	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}
	public MultipartFile getFile3() {
		return file3;
	}
	public void setFile3(MultipartFile file3) {
		this.file3 = file3;
	}
	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", maker=" + maker + ", price=" + price + ", origin=" + origin
				+ ", material=" + material + ", quantity=" + quantity + ", imgPath=" + imgPath + ", location_x="
				+ location_x + ", location_y=" + location_y + ", location_z=" + location_z + ", category1_id="
				+ category1_id + ", category2_id=" + category2_id + ", category3_id=" + category3_id + ", event_num="
				+ event_num + ", file1=" + file1 + ", file2=" + file2 + ", file3=" + file3 + "]";
	}
	
	
}
