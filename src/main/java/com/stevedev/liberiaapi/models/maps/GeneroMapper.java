package com.stevedev.liberiaapi.models.maps;

import com.stevedev.liberiaapi.models.dtos.request.GeneroReq;
import com.stevedev.liberiaapi.models.dtos.response.GeneroRes;
import com.stevedev.liberiaapi.models.entities.Generos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneroMapper {
    GeneroRes toResponse(Generos entity);
    Generos toEntity(GeneroReq request);
}
