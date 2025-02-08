package com.stevedev.liberiaapi.controllers;

import com.stevedev.liberiaapi.models.dtos.request.GeneroReq;
import com.stevedev.liberiaapi.models.dtos.response.GeneroRes;
import com.stevedev.liberiaapi.services.IGeneroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/generos")
@RequiredArgsConstructor
public class GenerosController {
    private final IGeneroService generoService;

    // Agregar generos para posteriormente ser utilizados en los libros
    @PostMapping()
    public ResponseEntity<GeneroRes> create(@RequestBody GeneroReq req) {
        GeneroRes genero = generoService.create(req);

        return ResponseEntity.status(201).body(genero);
    }

    // Obtener todos los generos
    @GetMapping()
    public ResponseEntity<Page<GeneroRes>> findAll(Pageable pageable) {
        Page<GeneroRes> generos = generoService.findAll(pageable);

        return ResponseEntity.ok(generos);
    }
}
