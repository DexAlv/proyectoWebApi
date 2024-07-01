package com.ipn.mx.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.model.entities.Cliente;

public interface ClienteRepo extends CrudRepository<Cliente, Long>{
    
}
