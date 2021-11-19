package com.misiontic.parking_ms.controllers;

import com.misiontic.parking_ms.exceptions.TransactionNotFoundException;
import com.misiontic.parking_ms.models.Transaction;
import com.misiontic.parking_ms.repositories.TransactionRepository;
import com.misiontic.parking_ms.repositories.VehiculoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/Transaction")
    Transaction newTransaction (@RequestBody Transaction transaction){
        //transaction.setFecha_salida();
        return transactionRepository.save(transaction);
    }

    @PutMapping ("/Transaction/{id}")
    Transaction updateTransaction(@PathVariable String id){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("No se encontro la transacción"));

        transaction.setFecha_salida(new Date());
        Date fechaSalida =  transaction.getFecha_salida();
        transaction.setValorTotal( this.calcularTotal(transaction.getFecha_entrada(),transaction.getFecha_salida()) );
        return transactionRepository.save(transaction);

    }

    @GetMapping("/Transaction/{id}")
    Transaction getTransaction(@PathVariable String id){
        return transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("No se encontro la transacción"));
    }

    @GetMapping("/dimelo")
    String imprimir(){
        String resultado = "Funcionan los getters";
        return resultado;
    }

    @GetMapping("/date")
    Date imprimirFecha(){
        Date resultado = new Date();
        return resultado;
    }



       Double calcularTotal(Date entrada, Date salida){
            double valorHora = 2000;
            Long diferencia =salida.getTime() - entrada.getTime() ; // tiempo de diferencia en milisegundos
            Long segundos = diferencia / 1000;
            Long horas = segundos / 3600;
            Double valorTotal = horas * valorHora;
            return valorTotal;
    }



}
