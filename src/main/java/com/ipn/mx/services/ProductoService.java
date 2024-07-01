package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.model.entities.Producto;

public interface ProductoService {
    public List<Producto> findAll();
    public Producto findById(Long Id);
    public void deleteById(Long Id);
    public Producto save(Producto producto);
}
