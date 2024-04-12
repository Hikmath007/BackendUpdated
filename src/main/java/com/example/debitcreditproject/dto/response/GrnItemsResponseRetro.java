package com.example.debitcreditproject.dto.response;

import com.example.debitcreditproject.entity.GrnEntity;

import lombok.Data;

@Data
public class GrnItemsResponse {

	private Long dispatchedquantity;
	private GrnEntity grnEntity;
	
}
