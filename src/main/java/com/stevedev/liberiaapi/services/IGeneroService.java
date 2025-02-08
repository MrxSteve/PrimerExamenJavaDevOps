package com.stevedev.liberiaapi.services;

import com.stevedev.liberiaapi.models.dtos.request.GeneroReq;
import com.stevedev.liberiaapi.models.dtos.response.GeneroRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneroService {
    GeneroRes create(GeneroReq req);
    Page<GeneroRes> findAll(Pageable pageable);
}
