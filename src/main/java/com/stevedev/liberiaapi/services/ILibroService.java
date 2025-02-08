package com.stevedev.liberiaapi.services;

import com.stevedev.liberiaapi.models.dtos.request.LibroReq;
import com.stevedev.liberiaapi.models.dtos.response.LibroRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILibroService {
    LibroRes create(LibroReq req);
    LibroRes update(Long id, LibroReq req);
    LibroRes getById(Long id);
    void delete(Long id);

    Page<LibroRes> getAll(Pageable pageable);
    Page<LibroRes> getByTitle(String title, Pageable pageable);
    Page<LibroRes> getByAuthor(String author, Pageable pageable);
    Page<LibroRes> getByGenre(String genre, Pageable pageable);
}
