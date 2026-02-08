package com.salesianos.com.viviendasjesus.Model;

import com.salesianos.com.viviendasjesus.Enum.EstadoVivienda;
import com.salesianos.com.viviendasjesus.Enum.TipoVivienda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "viviendas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vivienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(length = 2000)
    private String descripcion;

    @Column(nullable = false, length = 80)
    private String ciudad;

    @Column(nullable = false, length = 80)
    private String provincia;

    @Column(nullable = false)
    private Integer precio;

    @Column(nullable = false, name = "metros_cuadrados")
    private Integer metrosCuadrados;

    @Column(nullable = false)
    private Integer habitaciones;

    @Column(nullable = false)
    private Integer banos;

    @Enumerated(EnumType.STRING)
    private TipoVivienda tipo;

    @Enumerated(EnumType.STRING)
    private EstadoVivienda estado;

    @Column(nullable = false)
    private Boolean ascensor;

    @Column(nullable = false)
    private Boolean terraza;

    @Column(nullable = false)
    private Boolean garaje;

    @Column(nullable = false)
    private Boolean disponible;

    @Column(nullable = false, name = "fecha_publicacion")
    private LocalDate fechaPublicacion;
}