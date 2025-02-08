package com.stevedev.liberiaapi.models.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AutorRes {
    private Long id;
    private String nombre;
    private String nacionalidad;
    private Integer edad;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
