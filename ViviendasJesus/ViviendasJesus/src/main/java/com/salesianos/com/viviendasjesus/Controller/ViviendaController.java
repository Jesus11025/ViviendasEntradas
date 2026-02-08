package com.salesianos.com.viviendasjesus.Controller;

import com.salesianos.com.viviendasjesus.Dto.ViviendaCreateRequest;
import com.salesianos.com.viviendasjesus.Dto.ViviendaResponse;
import com.salesianos.com.viviendasjesus.Service.ViviendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/viviendas")
public class ViviendaController {

    private final ViviendaService viviendaService;

    @GetMapping
    public ResponseEntity<Page<ViviendaResponse>> getAllViviendas(
            @PageableDefault(size = 10, sort = "fechaPublicacion") Pageable lista) {

        Page<ViviendaResponse> viviendas = viviendaService.getAllViviendas(lista);

        return ResponseEntity.ok(viviendas);
    }

    @PostMapping
    public ResponseEntity<ViviendaResponse> crearVivienda(@Valid @RequestBody ViviendaCreateRequest viviendaCrear) {
        ViviendaResponse viviendaCreada = viviendaService.crearVivienda(viviendaCrear);
        return ResponseEntity.status(HttpStatus.CREATED).body(viviendaCreada);
    }


}
