package com.ipn.mx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.model.entities.Categoria;
import com.ipn.mx.model.repositories.CategoriaRepo;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepo repository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return (List<Categoria>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findById(Long id) {
        Optional<Categoria> optionalCategoria = repository.findById(id);
        return optionalCategoria.orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }
}