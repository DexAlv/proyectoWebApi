package com.ipn.mx.integration;

import com.ipn.mx.model.entities.Proveedor;
import com.ipn.mx.services.ProveedorService;

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
@RequestMapping("/apiProveedores")
public class ProveedorController {
    @Autowired
    ProveedorService service;

    @GetMapping("/proveedores")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Proveedor> mostrarProveedores() {
        return service.findAll();
    }

    @GetMapping("/proveedores/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Proveedor mostrarProveedor(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/proveedores")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Proveedor crearProveedor(@RequestBody Proveedor proveedor) {
        return service.save(proveedor);
    }

    @DeleteMapping("/proveedores/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/proveedores/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Proveedor actualizarProveedor(@RequestBody Proveedor proveedor, @PathVariable Long id) {
        Proveedor p = service.findById(id);
        p.setNombreProveedor(proveedor.getNombreProveedor());
        p.setNumeroTelefono(proveedor.getNumeroTelefono());
        p.setEmail(proveedor.getEmail());
        return service.save(p);
    }
}
