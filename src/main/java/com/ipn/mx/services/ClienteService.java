package com.ipn.mx.services;

import java.util.List;

import com.ipn.mx.model.entities.Cliente;

public interface ClienteService {
    public List<Cliente> findAll();
    public Cliente findById(Long Id);
    public void deleteById(Long Id);
    public Cliente save(Cliente cliente);
}
