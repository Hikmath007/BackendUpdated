
package com.example.debitcreditproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.debitcreditproject.dto.StatusUpdateDto;
import com.example.debitcreditproject.dto.request.LinkDto;
import com.example.debitcreditproject.dto.response.InvoiceResponse;
import com.example.debitcreditproject.entity.InvoiceEntity;
import com.example.debitcreditproject.repository.InvoiceRepo;
import com.example.debitcreditproject.service.ValidationService;
import com.example.debitcreditproject.utils.CustomMultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ValidationController {

	@Autowired
	private ValidationService validationService;

	@Autowired
	InvoiceRepo invoiceRepo;

	@GetMapping("/upload")
	public Boolean uploadfunction() {
		log.info("Received request to upload function");
		return validationService.uploadfun();
	}

	@GetMapping("/sendData")
	public String sendClienData() {
		log.info("Received request to send client data");
	
		return validationService.sendData();
	}

	@PostMapping("/validate")
	public String validate(@RequestBody LinkDto links) {
		log.info("Received request to validate with links: {}", links);

		RestTemplate restTemplate = new RestTemplate();
		MultipartFile excelFile = null;
		List<String> pdfs = new ArrayList<String>();
		for (String link : links.getUrls()) {
			if (isPdf(link)) {
				pdfs.add(link);
			} else if (isExcel(link)) {
				excelFile = fetchExcelFile(restTemplate, link);
			}

		}

		return validationService.validationFunction(excelFile, pdfs);
	}

	// -----------------------
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	private boolean isPdf(String link) {
		String extension = FilenameUtils.getExtension(link);
		return "pdf".equalsIgnoreCase(extension);
	}

	private boolean isExcel(String link) {
		String extension = FilenameUtils.getExtension(link);
		return "xlsx".equalsIgnoreCase(extension) || "xls".equalsIgnoreCase(extension);
	}

	public MultipartFile fetchExcelFile(RestTemplate restTemplate, String url) {

		 log.info("Fetching Excel file from URL: {}", url);
		byte[] response = restTemplate.getForObject(url, byte[].class);

		String[] fileName = url.split("/");

		MultipartFile file = new CustomMultipartFile(response, fileName[fileName.length - 1]);

		return file;

	}

	@PostMapping("/updateStatusPending")
	public void updateStatusPending(@RequestBody List<String> invoiceNumbers) {

		validationService.updateStatusPending(invoiceNumbers);
	}

	@PostMapping(value = "/updateStatusPass", consumes = { "multipart/form-data" })
	public String acceptList(StatusUpdateDto statusUpdateDto) {

		log.info("" + statusUpdateDto.getInvoiceNumbers());
		validationService.sendUpdatedData(statusUpdateDto.getFile(), statusUpdateDto.getInvoiceNumbers());
		return "status is updated in backend";
	}

	@GetMapping("/fetchAllData")
	public String fetchAllData() {

		return validationService.fetchAllData();
	}

	@PutMapping("/update-approvedlist")
	public String updateApprovedList(@RequestBody List<String> invoiceNumbers) {
		return validationService.updateApprovedList(invoiceNumbers);
	}

	@PutMapping("/update-rejectedlist")
	public String updateRejectedList(@RequestBody List<String> invoiceNumbers) {
		return validationService.updatedRejectedList(invoiceNumbers);
	}

	@GetMapping("/approved-invoices-list")
	public List<InvoiceResponse> showAllApprovedInvoices() {

		return validationService.showAllApprovedInvoices();
	}

	@GetMapping("/rejected-invoices-list")
	public List<InvoiceResponse> showAllRejectedInvoices() {

		return validationService.showAllRejectedInvoices();
	}

}
