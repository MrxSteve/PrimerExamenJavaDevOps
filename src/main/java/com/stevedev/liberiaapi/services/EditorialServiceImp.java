package com.stevedev.liberiaapi.services;

import com.stevedev.liberiaapi.models.dtos.request.EditorialReq;
import com.stevedev.liberiaapi.models.dtos.response.EditorialRes;
import com.stevedev.liberiaapi.models.entities.Editorial;
import com.stevedev.liberiaapi.models.maps.EditorialMapper;
import com.stevedev.liberiaapi.repositories.EditorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditorialServiceImp implements IEditorialService {
    private final EditorialRepository editorialRepository;
    private final EditorialMapper editorialMapper;

    @Override
    public EditorialRes create(EditorialReq req) {
        Editorial entity = editorialMapper.toEntity(req);
        Editorial savedEntity = editorialRepository.save(entity);

        return editorialMapper.toResponse(savedEntity);
    }

    @Override
    public Page<EditorialRes> findAll(Pageable pageable) {
        Page<Editorial> entities = editorialRepository.findAll(pageable);

        return entities.map(editorialMapper::toResponse);
    }
}
