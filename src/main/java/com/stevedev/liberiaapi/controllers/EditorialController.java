package com.stevedev.liberiaapi.controllers;

import com.stevedev.liberiaapi.models.dtos.request.EditorialReq;
import com.stevedev.liberiaapi.models.dtos.response.EditorialRes;
import com.stevedev.liberiaapi.services.IEditorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/editoriales")
@RequiredArgsConstructor
public class EditorialController {
    private final IEditorialService editorialService;

    // Agregar editoriales para posteriormente poder agregar libros
    @PostMapping()
    public ResponseEntity<EditorialRes> create(@RequestBody EditorialReq req) {
        EditorialRes editorialRes = editorialService.create(req);

        return ResponseEntity.status(201).body(editorialRes);
    }

    // Obtener todas las editoriales
    @GetMapping()
    public ResponseEntity<Page<EditorialRes>> findAll(Pageable pageable) {
        Page<EditorialRes> editoriales = editorialService.findAll(pageable);

        return ResponseEntity.ok(editoriales);
    }
}
