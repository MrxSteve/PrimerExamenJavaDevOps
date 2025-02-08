package com.stevedev.liberiaapi.models.maps;

import com.stevedev.liberiaapi.models.dtos.request.LibroReq;
import com.stevedev.liberiaapi.models.dtos.response.LibroRes;
import com.stevedev.liberiaapi.models.entities.Libros;
import com.stevedev.liberiaapi.models.entities.Generos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface LibrosMapper {

    @Mapping(source = "autor.nombre", target = "autorNombre")
    @Mapping(source = "editorial.nombre", target = "editorialNombre")
    @Mapping(source = "generos", target = "generos", qualifiedByName = "mapGenerosToString")
    LibroRes toResponse(Libros entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "autorId", target = "autor.id")
    @Mapping(source = "editorialId", target = "editorial.id")
    @Mapping(source = "generosIds", target = "generos", qualifiedByName = "mapGeneros")
    Libros toEntity(LibroReq request);

    // 🔹 Metodo auxiliar para convertir `List<Long>` (IDs de géneros) a `List<Generos>`
    @Named("mapGeneros")
    static List<Generos> mapGeneros(List<Long> generosIds) {
        if (generosIds == null) return null;
        return generosIds.stream().map(id -> {
            Generos genero = new Generos();
            genero.setId(id);
            return genero;
        }).collect(Collectors.toList());
    }

    // 🔹 Metodo auxiliar para convertir `List<Generos>` a `List<String>` (nombres)
    @Named("mapGenerosToString")
    static List<String> mapGenerosToString(List<Generos> generos) {
        if (generos == null) return null;
        return generos.stream()
                .map(Generos::getNombre)
                .collect(Collectors.toList());
    }
}
