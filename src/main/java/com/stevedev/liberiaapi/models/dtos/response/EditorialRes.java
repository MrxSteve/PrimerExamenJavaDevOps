package com.stevedev.liberiaapi.models.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EditorialRes {
    private Long id;
    private String nombre;
    private String ubicacion;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
