package com.stevedev.liberiaapi.services;

import com.stevedev.liberiaapi.models.dtos.request.AutorReq;
import com.stevedev.liberiaapi.models.dtos.response.AutorRes;
import com.stevedev.liberiaapi.models.entities.Autores;
import com.stevedev.liberiaapi.models.maps.AutorMapper;
import com.stevedev.liberiaapi.repositories.AutorRepositoty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AutorServiceImp implements IAutorService {
    @Autowired
    private AutorMapper autorMapper;
    @Autowired
    private AutorRepositoty autorRepositoty;

    @Override
    public AutorRes create(AutorReq req) {
        Autores entity = autorMapper.toEntity(req);
        Autores savedEntity = autorRepositoty.save(entity);

        return autorMapper.toResponse(savedEntity);
    }

    @Override
    public Page<AutorRes> findAll(Pageable pageable) {
        Page<Autores> entities = autorRepositoty.findAll(pageable);

        return entities.map(autorMapper::toResponse);
    }
}
