package com.stevedev.liberiaapi.controllers;

import com.stevedev.liberiaapi.models.dtos.request.AutorReq;
import com.stevedev.liberiaapi.models.dtos.response.AutorRes;
import com.stevedev.liberiaapi.services.IAutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/autores")
@RequiredArgsConstructor
public class AutorController {
    private final IAutorService autorService;

    // Agregar autores para posteriormente poder agregar libros
    @PostMapping()
    public ResponseEntity<AutorRes> create(@RequestBody AutorReq req) {
        AutorRes autorRes = autorService.create(req);

        return ResponseEntity.status(201).body(autorRes);
    }

    // Obtener todos los autores
    @GetMapping()
    public ResponseEntity<Page<AutorRes>> findAll(Pageable pageable) {
        Page<AutorRes> autores = autorService.findAll(pageable);

        return ResponseEntity.ok(autores);
    }
}
