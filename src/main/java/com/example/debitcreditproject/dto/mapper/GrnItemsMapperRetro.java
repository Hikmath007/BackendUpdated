package com.example.debitcreditproject.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mapping;

import com.example.debitcreditproject.dto.response.GrnItemsResponse;
import com.example.debitcreditproject.entity.GrnItem;

@Mapper(componentModel = "spring")
public interface GrnItemsMapper {
	
	GrnItem fromResponseToEntity(GrnItemsResponse grnitemResponse);


	GrnItemsResponse fromEntityToResponse(GrnItem grnItem);

}
