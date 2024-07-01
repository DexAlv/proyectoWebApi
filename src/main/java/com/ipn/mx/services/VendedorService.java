package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.model.entities.Vendedor;

public interface VendedorService {
    public List<Vendedor> findAll();
    public Vendedor findById(Long Id);
    public void deleteById(Long Id);
    public Vendedor save(Vendedor vendedor);
}
