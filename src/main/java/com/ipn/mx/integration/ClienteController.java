package com.ipn.mx.integration;

import com.ipn.mx.model.entities.Cliente;
import com.ipn.mx.services.ClienteService;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/apiClientes")
public class ClienteController {
    @Autowired
    ClienteService service;

    @GetMapping("/clientes")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Cliente> mostrarClientes() {
        return service.findAll();
    }

    @GetMapping("/clientes/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Cliente mostrarCliente(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return service.save(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Cliente actualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente c = service.findById(id);
        c.setNombreCliente(cliente.getNombreCliente());
        c.setDireccion(cliente.getDireccion());
        c.setTelefono(cliente.getTelefono());
        c.setEmail(cliente.getEmail());
        c.setVendedor(cliente.getVendedor());
        return service.save(c);
    }
}
