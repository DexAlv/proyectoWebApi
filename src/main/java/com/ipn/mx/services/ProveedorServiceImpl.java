package com.ipn.mx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.model.entities.Proveedor;
import com.ipn.mx.model.repositories.ProveedorRepo;

@Service
public class ProveedorServiceImpl implements ProveedorService{
    @Autowired
    ProveedorRepo repository;

    @Override
    @Transactional(readOnly = true)
    public List<Proveedor> findAll() {
        return (List<Proveedor>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedor findById(Long id) {
        Optional<Proveedor> optionalProveedor = repository.findById(id);
        return optionalProveedor.orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Proveedor save(Proveedor proveedor) {
        return repository.save(proveedor);
    }


}
