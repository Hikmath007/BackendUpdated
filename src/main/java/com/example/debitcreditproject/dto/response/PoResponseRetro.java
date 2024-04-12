package com.example.debitcreditproject.dto.response;

import java.util.List;

import lombok.Data;


@Data
public class PoResponse {

	
	private String poNumber;

	
	private VendorResponse vendor;

	
//	private List<PoItemResponse> poitems;
}
