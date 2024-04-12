package com.example.debitcreditproject.dto.response;

import com.example.debitcreditproject.entity.GrnItem;

import lombok.Data;

@Data
public class InvoiceResponse {
	private String invoiceNumber;
    private String bookingStatus;
    private String invoiceDate;
    private String status;
    private String amount;
    private String attachment;
    private String poNumber;
    private String grnNumber;
    private String materialCode;
    private Long invoicequantity;
	private String grnDate;
	private String basicPrice;
	private int gst;
    private GrnItem grnItems;

}
