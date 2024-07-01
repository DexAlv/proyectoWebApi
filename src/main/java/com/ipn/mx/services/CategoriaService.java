package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.model.entities.Categoria;

public interface CategoriaService {
    public List<Categoria> findAll();
    public Categoria findById(Long Id);
    public void deleteById(Long Id);
    public Categoria save(Categoria categoria);
}
