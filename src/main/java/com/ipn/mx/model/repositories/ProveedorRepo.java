package com.ipn.mx.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.model.entities.Proveedor;

public interface ProveedorRepo extends  CrudRepository<Proveedor, Long>{
    
}
