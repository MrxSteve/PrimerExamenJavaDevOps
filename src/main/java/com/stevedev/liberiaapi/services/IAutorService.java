package com.stevedev.liberiaapi.services;

import com.stevedev.liberiaapi.models.dtos.request.AutorReq;
import com.stevedev.liberiaapi.models.dtos.response.AutorRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAutorService {
    AutorRes create(AutorReq req);
    Page<AutorRes> findAll(Pageable pageable);
}
