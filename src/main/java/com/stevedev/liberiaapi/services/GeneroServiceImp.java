package com.stevedev.liberiaapi.services;

import com.stevedev.liberiaapi.models.dtos.request.GeneroReq;
import com.stevedev.liberiaapi.models.dtos.response.GeneroRes;
import com.stevedev.liberiaapi.models.entities.Generos;
import com.stevedev.liberiaapi.models.maps.GeneroMapper;
import com.stevedev.liberiaapi.repositories.GeneroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneroServiceImp implements IGeneroService{
    private final GeneroRepository generoRepository;
    private final GeneroMapper generoMapper;

    @Override
    public GeneroRes create(GeneroReq req) {
        Generos entity = generoMapper.toEntity(req);
        Generos savedEntity = generoRepository.save(entity);

        return generoMapper.toResponse(savedEntity);
    }

    @Override
    public Page<GeneroRes> findAll(Pageable pageable) {
        Page<Generos> entities = generoRepository.findAll(pageable);

        return entities.map(generoMapper::toResponse);
    }
}
