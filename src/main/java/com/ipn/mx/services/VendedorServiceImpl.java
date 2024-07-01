package com.ipn.mx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.model.entities.Vendedor;
import com.ipn.mx.model.repositories.VendedorRepo;

@Service
public class VendedorServiceImpl implements VendedorService {
    @Autowired
    VendedorRepo repository;

    @Override
    @Transactional(readOnly = true)
    public List<Vendedor> findAll() {
        return (List<Vendedor>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vendedor findById(Long id) {
        Optional<Vendedor> optionalVendedor = repository.findById(id);
        return optionalVendedor.orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Vendedor save(Vendedor vendedor) {
        return repository.save(vendedor);
    }
}
