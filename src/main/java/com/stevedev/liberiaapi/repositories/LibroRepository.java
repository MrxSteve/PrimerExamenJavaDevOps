package com.stevedev.liberiaapi.repositories;

import com.stevedev.liberiaapi.models.entities.Libros;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libros, Long> {
    // Buscar libros por título
    Page<Libros> findByTituloContainingIgnoreCaseOrderByTituloAsc(String titulo, Pageable pageable);
    // Buscar libros por autor
    Page<Libros> findByAutor_NombreContainingIgnoreCaseOrderByTituloAsc(String nombreAutor, Pageable pageable);
    // Buscar libros por género
    Page<Libros> findByGeneros_NombreContainingIgnoreCaseOrderByTituloAsc(String nombreGenero, Pageable pageable);
}
