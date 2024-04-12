
package com.example.debitcreditproject.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.debitcreditproject.dto.response.InvoiceResponse;
import com.example.debitcreditproject.entity.InvoiceEntity;
import com.example.debitcreditproject.entity.PoItem;

public interface ValidationService {

	String validationFunction(MultipartFile file, List<String> links);

	Boolean uploadfun();

	String sendData();

	String sendUpdatedData(MultipartFile file, List<String> invoiceNumbers);

	void updateStatusPending(List<String> invoiceNumbers);

	String fetchAllData();
	
     String updateApprovedList(List<String> invoiceNumbers);
     
     String updatedRejectedList(List<String> invoiceNumbers);
     
     List<InvoiceResponse> showAllApprovedInvoices();
     
     List<InvoiceResponse> showAllRejectedInvoices();
}
