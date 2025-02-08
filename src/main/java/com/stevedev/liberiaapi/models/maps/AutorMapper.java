package com.stevedev.liberiaapi.models.maps;

import com.stevedev.liberiaapi.models.dtos.request.AutorReq;
import com.stevedev.liberiaapi.models.dtos.response.AutorRes;
import com.stevedev.liberiaapi.models.entities.Autores;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AutorMapper {
    AutorRes toResponse(Autores entity);
    Autores toEntity(AutorReq request);
}
