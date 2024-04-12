package com.example.debitcreditproject.dto.response;

import java.util.List;

import com.example.debitcreditproject.entity.MaterialEntity;
import com.example.debitcreditproject.entity.PoEntity;
import com.example.debitcreditproject.entity.RateEntity;

import lombok.Data;

@Data
public class PoItemResponse {

		private Long id;

		private int gst;

		private PoResponse poid;
	

		private MaterialResponse poItemMaterial;

		private String price;

		private Long quantity;

		private List<GrnItemsResponse> grn_items;

		private RateResponse poItem;

	
}
