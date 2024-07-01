package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.model.entities.Proveedor;

public interface ProveedorService {
    public List<Proveedor> findAll();
    public Proveedor findById(Long Id);
    public void deleteById(Long Id);
    public Proveedor save(Proveedor proveedor);
}
