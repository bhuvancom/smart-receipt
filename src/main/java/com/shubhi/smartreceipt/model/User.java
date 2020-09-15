package com.shubhi.smartreceipt.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.*;

@Entity(name = "user")
public class User {

	@Id
	@Column(name = "user_id")
	@Generated // TODO: video me jo btae
	private Integer userId;

	@Column(name = "name")
	private String name;
	
	//TODO: aise hi sare table and column k liye class bna lo is model package me

}
