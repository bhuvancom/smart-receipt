package com.shubhi.smartreceipt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer productId;

	@Column(name = "product_code")
	private String productCode;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "product_price")
	private int productPrice;

	public Product(String productCode, String productDescription, int productPrice) {
		this.productCode = productCode;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}

	public Product() {
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product{" + "productId=" + productId + ", productCode='" + productCode + '\'' + ", productDescription='"
				+ productDescription + '\'' + ", productPrice=" + productPrice + '}';
	}
}
