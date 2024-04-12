package com.example.debitcreditproject.dto.request;

import lombok.Data;

@Data
public class InvoiceRequest {
    private String invoiceNumber;
    private String bookingStatus;
    private String invoiceDate;
    private String status;
    private String amount;
    
}
