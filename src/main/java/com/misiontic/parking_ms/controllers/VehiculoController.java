package com.misiontic.parking_ms.controllers;

import com.misiontic.parking_ms.exceptions.VehiculoNotFoundException;
import com.misiontic.parking_ms.models.Vehiculo;
import com.misiontic.parking_ms.repositories.VehiculoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehiculoController {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoController(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }





       @GetMapping("/vehiculo/{placa}")
          Vehiculo getVehiculo(@PathVariable String placa){
              return vehiculoRepository.findById(placa)
                      .orElseThrow(()-> new VehiculoNotFoundException("No se encontro el vehiculo"));
          }



    @PostMapping("/vehiculo")
    Vehiculo nuevoVehiculo(@RequestBody Vehiculo vehiculo){
        return vehiculoRepository.save(vehiculo);
    }

}

