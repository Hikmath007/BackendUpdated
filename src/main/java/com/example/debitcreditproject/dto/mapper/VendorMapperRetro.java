
package com.example.debitcreditproject.dto.mapper;

import com.example.debitcreditproject.entity.VendorEntity;
import org.mapstruct.Mapper;

import com.example.debitcreditproject.dto.request.VendorRequest;
import com.example.debitcreditproject.dto.response.VendorResponse;
import com.example.debitcreditproject.entity.VendorEntity;

@Mapper(componentModel = "spring", uses = VendorMapper.class)
public interface VendorMapper {

	VendorEntity fromRequestToEntity(VendorRequest vendorRequest);

	VendorResponse fromEntityToResponse(VendorEntity vendorEntity);
}
