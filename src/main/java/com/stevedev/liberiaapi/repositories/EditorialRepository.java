package com.stevedev.liberiaapi.repositories;

import com.stevedev.liberiaapi.models.entities.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorialRepository extends JpaRepository<Editorial, Long> {
}
