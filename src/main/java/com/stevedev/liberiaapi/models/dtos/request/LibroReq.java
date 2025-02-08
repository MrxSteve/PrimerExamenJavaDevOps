package com.stevedev.liberiaapi.models.dtos.request;

import lombok.Data;
import java.util.List;

@Data
public class LibroReq {
    private String titulo;
    private String descripcion;
    private Long autorId;
    private Long editorialId;
    private List<Long> generosIds;
}

