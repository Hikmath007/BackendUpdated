
package com.example.debitcreditproject.dto.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.debitcreditproject.dto.response.InvoiceResponse;
import com.example.debitcreditproject.entity.InvoiceEntity;

@Mapper(componentModel = "spring", uses = GrnMapper.class)
public interface InvoiceMapper {

	InvoiceEntity fromRequestToEntity(InvoiceResponse invoiceResponse);

	
	@Mapping(source ="grnItems.poitem.poid.poNumber",target="poNumber")
	@Mapping(source ="grnItems.grn.grnNumber",target="grnNumber")
	@Mapping(source ="grnItems.poitem.poItemMaterial.materialCode",target="materialCode")
	@Mapping(source ="grnItems.dispatchedquantity",target="invoicequantity")
	@Mapping(source ="grnItems.grn.grnDate",target="grnDate")
	@Mapping(source ="grnItems.poitem.price",target="basicPrice")
	@Mapping(source ="grnItems.poitem.gst",target="gst")
	
	InvoiceResponse fromEntityToResponse(InvoiceEntity invoiceEntity);

	List<InvoiceResponse> fromEntityToResponseList(List<InvoiceEntity> entityList);
}
