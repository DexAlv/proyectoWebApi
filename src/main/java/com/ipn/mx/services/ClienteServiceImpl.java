package com.ipn.mx.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.model.entities.Cliente;
import com.ipn.mx.model.repositories.ClienteRepo;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepo repository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        Optional<Cliente> optionalCliente = repository.findById(id);
        return optionalCliente.orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }
}
