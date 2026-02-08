package com.salesianos.com.viviendasjesus.Dto;

import com.salesianos.com.viviendasjesus.Enum.EstadoVivienda;
import com.salesianos.com.viviendasjesus.Enum.TipoVivienda;

import java.time.LocalDate;

public record ViviendaResponse(
        Long id,
        String titulo,
        String ciudad,
        String provincia,
        Integer precio,
        Integer metrosCuadrados,
        Integer habitaciones,
        Integer banos,
        TipoVivienda tipo,
        EstadoVivienda estado,
        Boolean disponible,
        LocalDate fechaPublicacion
) {
}
