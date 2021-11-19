package com.misiontic.parking_ms.controllers;

import com.misiontic.parking_ms.exceptions.VehiculoNotFoundException;
import com.misiontic.parking_ms.models.Vehiculo;
import com.misiontic.parking_ms.repositories.VehiculoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehiculoController {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoController(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    /**
     * Obtiene la informacion del vehiculo que coincida con la placa enviada
     * @param placa
     * @return
     */
    @GetMapping("/vehiculo/{placa}")
    Vehiculo getVehiculo(@PathVariable String placa) {
        return vehiculoRepository.findById(placa)
                .orElseThrow(() -> new VehiculoNotFoundException("No se encontro el vehiculo"));
    }

    /**
     * Obtiene una lista de todos los vehiculos almacenados en bases de datos
     *
     * @return
     */
    @GetMapping("/vehiculos")
    List<Vehiculo> getVehiculos() {
        return vehiculoRepository.findAll();
    }

    // utilizar para dar salida a un verhiculo.
    @PutMapping("/vehiculo/{placa}")
        Vehiculo updateVehiculo(@PathVariable String placa){
            Vehiculo vehiculo =  vehiculoRepository.findById(placa)
                    .orElseThrow(()-> new VehiculoNotFoundException("No se encontro el vehiculo"));
            vehiculo.setEstaDentro(false);
            return vehiculoRepository.save(vehiculo);
        }


    @PostMapping("/vehiculo")
    Vehiculo nuevoVehiculo(@RequestBody Vehiculo vehiculo){
        String placa = vehiculo.getPlaca();
        try {
            Vehiculo vehiculoDentro = vehiculoRepository.findById(placa)
                    .orElseThrow(()-> new VehiculoNotFoundException("No se encontro el vehiculo"));
            if(vehiculoDentro!= null){
                vehiculo.setEstaDentro(true);
                vehiculoDentro = vehiculo;
                return vehiculoDentro;
            }else{
                return vehiculoRepository.save(vehiculo);
            }
        }catch (VehiculoNotFoundException ex){
            System.out.print("No se encontro el vehiculo");
        }
        return vehiculoRepository.save(vehiculo);
    }



}

