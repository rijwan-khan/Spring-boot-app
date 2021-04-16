package com.zensar.dto;

import java.util.Calendar;

import lombok.Data;

@Data
public class ProductRequest {

	private Long id;
	private String name;
	private Double price;
	private Calendar createdDate;
	private Calendar expDate;

}
