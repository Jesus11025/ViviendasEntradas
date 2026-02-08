package com.salesianos.com.viviendasjesus.Service;

import com.salesianos.com.viviendasjesus.Dto.ViviendaCreateRequest;
import com.salesianos.com.viviendasjesus.Dto.ViviendaResponse;
import com.salesianos.com.viviendasjesus.Model.Vivienda;
import com.salesianos.com.viviendasjesus.Repository.ViviendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class ViviendaService {

    private final ViviendaRepository viviendaRepository;

    public Page<ViviendaResponse> getAllViviendas(Pageable pageable) {
        Page<Vivienda> viviendas = viviendaRepository.findAll(pageable);
        return viviendaRepository.findAll(pageable)
                .map(v -> new ViviendaResponse(
                        v.getId(),
                        v.getTitulo(),
                        v.getCiudad(),
                        v.getProvincia(),
                        v.getPrecio(),
                        v.getMetrosCuadrados(),
                        v.getHabitaciones(),
                        v.getBanos(),
                        v.getTipo(),
                        v.getEstado(),
                        v.getDisponible(),
                        v.getFechaPublicacion()
                ));
    }

    public ViviendaResponse crearVivienda(ViviendaCreateRequest viviendaCrear) {
        if (viviendaCrear.precio() > 1000000) {
            throw new IllegalArgumentException("precio fuera de rango");
        }

        if (viviendaCrear.metrosCuadrados() > 1000) {
            throw new IllegalArgumentException("metrosCuadrados fuera de rango");
        }

        Vivienda vivienda = new Vivienda();
        vivienda.setTitulo(viviendaCrear.titulo());
        vivienda.setDescripcion(viviendaCrear.descripcion());
        vivienda.setCiudad(viviendaCrear.ciudad());
        vivienda.setProvincia(viviendaCrear.provincia());
        vivienda.setPrecio(viviendaCrear.precio());
        vivienda.setMetrosCuadrados(viviendaCrear.metrosCuadrados());
        vivienda.setHabitaciones(viviendaCrear.habitaciones());
        vivienda.setBanos(viviendaCrear.banos());
        vivienda.setTipo(viviendaCrear.tipo());
        vivienda.setEstado(viviendaCrear.estado());
        vivienda.setAscensor(viviendaCrear.ascensor());
        vivienda.setTerraza(viviendaCrear.terraza());
        vivienda.setGaraje(viviendaCrear.garaje());
        vivienda.setDisponible(viviendaCrear.disponible());
        vivienda.setFechaPublicacion(LocalDate.now());

        Vivienda viviendaGuardada = viviendaRepository.save(vivienda);

        return new ViviendaResponse(
                vivienda.getId(),
                vivienda.getTitulo(),
                vivienda.getCiudad(),
                vivienda.getProvincia(),
                vivienda.getPrecio(),
                vivienda.getMetrosCuadrados(),
                vivienda.getHabitaciones(),
                vivienda.getBanos(),
                vivienda.getTipo(),
                vivienda.getEstado(),
                vivienda.getDisponible(),
                vivienda.getFechaPublicacion()
        );
    }



}
