package com.misiontic.parking_ms.repositories;

import com.misiontic.parking_ms.models.Vehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehiculoRepository  extends MongoRepository<Vehiculo, String> {
}
