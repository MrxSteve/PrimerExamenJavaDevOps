package com.stevedev.liberiaapi.controllers;

import com.stevedev.liberiaapi.models.dtos.request.LibroReq;
import com.stevedev.liberiaapi.models.dtos.response.LibroRes;
import com.stevedev.liberiaapi.services.ILibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libros")
@RequiredArgsConstructor
public class LibroController {

    private final ILibroService libroService;

    // Crear un libro
    @PostMapping()
    public ResponseEntity<LibroRes> crearLibro(@RequestBody LibroReq req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.create(req));
    }

    // Actualizar un libro por ID
    @PutMapping("/{id}")
    public ResponseEntity<LibroRes> actualizarLibro(@PathVariable Long id, @RequestBody LibroReq req) {
        return ResponseEntity.ok(libroService.update(id, req));
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<LibroRes> obtenerLibroPorId(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.getById(id));
    }

    // Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Obtener todos los libros (con paginación)
    @GetMapping()
    public ResponseEntity<Page<LibroRes>> obtenerLibros(Pageable pageable) {
        return ResponseEntity.ok(libroService.getAll(pageable));
    }

    // Buscar libros por título (ordenados alfabéticamente)
    @GetMapping("/buscar/titulo")
    public ResponseEntity<Page<LibroRes>> buscarPorTitulo(@RequestParam String titulo, Pageable pageable) {
        return ResponseEntity.ok(libroService.getByTitle(titulo, pageable));
    }

    // Buscar libros por autor (ordenados alfabéticamente)
    @GetMapping("/buscar/autor")
    public ResponseEntity<Page<LibroRes>> buscarPorAutor(@RequestParam String autor, Pageable pageable) {
        return ResponseEntity.ok(libroService.getByAuthor(autor, pageable));
    }

    // Buscar libros por género (ordenados alfabéticamente)
    @GetMapping("/buscar/genero")
    public ResponseEntity<Page<LibroRes>> buscarPorGenero(@RequestParam String genero, Pageable pageable) {
        return ResponseEntity.ok(libroService.getByGenre(genero, pageable));
    }
}
