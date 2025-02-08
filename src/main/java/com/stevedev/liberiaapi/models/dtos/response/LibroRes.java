package com.stevedev.liberiaapi.models.dtos.response;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class LibroRes {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String autorNombre;
    private String editorialNombre;
    private List<String> generos;
}

