package com.salesianos.com.viviendasjesus.Dto;

import com.salesianos.com.viviendasjesus.Enum.EstadoVivienda;
import com.salesianos.com.viviendasjesus.Enum.TipoVivienda;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ViviendaCreateRequest(

        @NotBlank(message = "El titulo no puede estar vacío")
        @Size(max = 120, message = "El titulo tiene mas de 120 caracteres")
        String titulo,

        @Size(max = 2000, message = "La descripcion tiene mas de 2000 caracteres")
        String descripcion,

        @NotBlank(message = "La ciudad no puede estar vacía")
        @Size(max = 80, message = "La ciudad no puede superar los 80 caracteres")
        String ciudad,

        @NotBlank(message = "La provincia no puede estar vacía")
        @Size(max = 80, message = "La provincia no puede superar los 80 caracteres")
        String provincia,

        @NotNull(message = "El precio no puede ser nulo")
        @Min(value = 0, message = "El precio debe ser mayor o igual a 0")
        Integer precio,

        @NotNull(message = "Los metros cuadrados no pueden ser nulos")
        @Min(value = 1, message = "Los metros cuadrados deben ser al menos 1")
        Integer metrosCuadrados,

        @NotNull(message = "Las habitaciones no pueden ser nulas")
        @Min(value = 0, message = "Las habitaciones deben ser 0 o mayor")
        Integer habitaciones,

        @NotNull(message = "Los baños no pueden ser nulos")
        @Min(value = 0, message = "Los baños deben ser 0 o mayor")
        Integer banos,

        @NotNull(message = "El tipo de vivienda no puede ser nulo")
        TipoVivienda tipo,

        @NotNull(message = "El estado de vivienda no puede ser nulo")
        EstadoVivienda estado,

        @NotNull(message = "El campo ascensor no puede ser nulo")
        Boolean ascensor,

        @NotNull(message = "El campo terraza no puede ser nulo")
        Boolean terraza,

        @NotNull(message = "El campo garaje no puede ser nulo")
        Boolean garaje,

        @NotNull(message = "El campo disponible no puede ser nulo")
        Boolean disponible
) {
}
