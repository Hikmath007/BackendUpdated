package com.example.debitcreditproject.dto.response;

import java.util.Date;

import lombok.Data;

@Data
public class RateResponse {

	private Long id;

	private Long oldRate;

	private Long newRate;

	private Date date;

	private PoItemResponse poitems;

}
