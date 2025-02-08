package com.stevedev.liberiaapi.services;

import com.stevedev.liberiaapi.models.dtos.request.EditorialReq;
import com.stevedev.liberiaapi.models.dtos.response.EditorialRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEditorialService {;
    EditorialRes create(EditorialReq req);
    Page<EditorialRes> findAll(Pageable pageable);
}
