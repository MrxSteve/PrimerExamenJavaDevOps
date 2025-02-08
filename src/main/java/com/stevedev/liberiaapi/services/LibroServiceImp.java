package com.stevedev.liberiaapi.services;

import com.stevedev.liberiaapi.models.dtos.request.LibroReq;
import com.stevedev.liberiaapi.models.dtos.response.LibroRes;
import com.stevedev.liberiaapi.models.entities.Autores;
import com.stevedev.liberiaapi.models.entities.Editorial;
import com.stevedev.liberiaapi.models.entities.Generos;
import com.stevedev.liberiaapi.models.entities.Libros;
import com.stevedev.liberiaapi.models.maps.LibrosMapper;
import com.stevedev.liberiaapi.repositories.AutorRepositoty;
import com.stevedev.liberiaapi.repositories.EditorialRepository;
import com.stevedev.liberiaapi.repositories.GeneroRepository;
import com.stevedev.liberiaapi.repositories.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroServiceImp implements ILibroService {
    private final LibroRepository libroRepository;
    private final LibrosMapper librosMapper;
    private final AutorRepositoty autorRepository;
    private final EditorialRepository editorialRepository;
    private final GeneroRepository generoRepository;

    // Crear un libro
    @Override
    public LibroRes create(LibroReq req) {
        Libros libro = librosMapper.toEntity(req);
        Libros libroGuardado = libroRepository.save(libro);
        return librosMapper.toResponse(libroGuardado);
    }

    // Actualizar un libro por ID
    @Override
    public LibroRes update(Long id, LibroReq req) {
        // Buscar el libro por ID
        Libros libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro con ID: " + id + " no encontrado"));

        // Actualizar SOLO si los valores son proporcionados (evitar null)
        if (req.getTitulo() != null && !req.getTitulo().isEmpty()) {
            libro.setTitulo(req.getTitulo());
        }

        if (req.getDescripcion() != null && !req.getDescripcion().isEmpty()) {
            libro.setDescripcion(req.getDescripcion());
        }

        if (req.getAutorId() != null && !libro.getAutor().getId().equals(req.getAutorId())) {
            Autores autor = autorRepository.findById(req.getAutorId())
                    .orElseThrow(() -> new RuntimeException("Autor con ID " + req.getAutorId() + " no encontrado"));
            libro.setAutor(autor);
        }

        if (req.getEditorialId() != null && !libro.getEditorial().getId().equals(req.getEditorialId())) {
            Editorial editorial = editorialRepository.findById(req.getEditorialId())
                    .orElseThrow(() -> new RuntimeException("Editorial con ID " + req.getEditorialId() + " no encontrada"));
            libro.setEditorial(editorial);
        }

        if (req.getGenerosIds() != null && !req.getGenerosIds().isEmpty()) {
            List<Long> nuevosGenerosIds = req.getGenerosIds();
            List<Long> generosActualesIds = libro.getGeneros().stream().map(Generos::getId).toList();

            if (!generosActualesIds.equals(nuevosGenerosIds)) {
                List<Generos> nuevosGeneros = generoRepository.findAllById(nuevosGenerosIds);
                libro.setGeneros(nuevosGeneros);
            }
        }

        // Guardar el libro actualizado
        Libros libroActualizado = libroRepository.save(libro);

        // Convertir a DTO de respuesta
        return librosMapper.toResponse(libroActualizado);
    }

    // Obtener un libro por ID
    @Override
    public LibroRes getById(Long id) {
        Libros libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro con ID: " + id + " no encontrado"));

        return librosMapper.toResponse(libro);
    }

    // Eliminar un libro por ID
    @Override
    public void delete(Long id) {
        Libros libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro con ID: " + id + " no encontrado"));

        libroRepository.delete(libro);
    }

    // Obtener todos los libros (paginados)
    @Override
    public Page<LibroRes> getAll(Pageable pageable) {
        Page<Libros> libros = libroRepository.findAll(pageable);
        return libros.map(librosMapper::toResponse);
    }

    // Buscar libros por título (orden alfabético)
    @Override
    public Page<LibroRes> getByTitle(String title, Pageable pageable) {
        Page<Libros> libros = libroRepository.findByTituloContainingIgnoreCaseOrderByTituloAsc(title, pageable);
        return libros.map(librosMapper::toResponse);
    }

    // Buscar libros por autor (orden alfabético)
    @Override
    public Page<LibroRes> getByAuthor(String author, Pageable pageable) {
        Page<Libros> libros = libroRepository.findByAutor_NombreContainingIgnoreCaseOrderByTituloAsc(author, pageable);
        return libros.map(librosMapper::toResponse);
    }

    // Buscar libros por género (orden alfabético)
    @Override
    public Page<LibroRes> getByGenre(String genre, Pageable pageable) {
        Page<Libros> libros = libroRepository.findByGeneros_NombreContainingIgnoreCaseOrderByTituloAsc(genre, pageable);
        return libros.map(librosMapper::toResponse);
    }
}
