package com.ipn.mx.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.model.entities.Producto;

public interface ProductoRepo extends CrudRepository<Producto, Long> {
    
}
