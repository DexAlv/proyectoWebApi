package com.ipn.mx.model.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ipn.mx.model.entities.Categoria;

public interface CategoriaRepo extends CrudRepository<Categoria, Long>{
    
}
