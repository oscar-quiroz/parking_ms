package com.misiontic.parking_ms.repositories;

import com.misiontic.parking_ms.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
