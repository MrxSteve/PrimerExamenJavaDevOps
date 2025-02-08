package com.stevedev.liberiaapi.models.maps;

import com.stevedev.liberiaapi.models.dtos.request.EditorialReq;
import com.stevedev.liberiaapi.models.dtos.response.EditorialRes;
import com.stevedev.liberiaapi.models.entities.Editorial;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EditorialMapper {
    EditorialRes toResponse(Editorial entity);
    Editorial toEntity(EditorialReq request);
}
