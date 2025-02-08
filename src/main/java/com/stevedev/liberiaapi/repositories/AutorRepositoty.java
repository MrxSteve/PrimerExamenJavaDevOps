package com.stevedev.liberiaapi.repositories;

import com.stevedev.liberiaapi.models.entities.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositoty extends JpaRepository<Autores, Long> {
}
