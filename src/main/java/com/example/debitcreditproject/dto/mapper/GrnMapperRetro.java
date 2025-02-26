
package com.example.debitcreditproject.dto.mapper;

import org.mapstruct.Mapper;

import com.example.debitcreditproject.dto.request.GrnRequest;
import com.example.debitcreditproject.dto.response.GrnResponse;
import com.example.debitcreditproject.entity.GrnEntity;

@Mapper(componentModel = "spring")
public interface GrnMapper {
	

	GrnEntity fromResponseToEntity(GrnResponse grnResponse);

	GrnResponse fromEntityToResponse(GrnEntity grnEntity);
}
