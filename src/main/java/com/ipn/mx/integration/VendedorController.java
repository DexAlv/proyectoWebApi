package com.ipn.mx.integration;

import com.ipn.mx.model.entities.Vendedor;
import com.ipn.mx.services.VendedorService;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/apiVendedores")
public class VendedorController {
    @Autowired
    VendedorService service;

    @GetMapping("/vendedores")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Vendedor> mostrarVendedores() {
        return service.findAll();
    }

    @GetMapping("/vendedores/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Vendedor mostrarVendedor(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/vendedores")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vendedor crearVendedor(@RequestBody Vendedor vendedor) {
        return service.save(vendedor);
    }

    @DeleteMapping("/vendedores/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/vendedores/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vendedor actualizarVendedor(@RequestBody Vendedor vendedor, @PathVariable Long id) {
        Vendedor v = service.findById(id);
        v.setNombreEmpleado(vendedor.getNombreEmpleado());
        v.setNumeroEmpleado(vendedor.getNumeroEmpleado());
        v.setProducto(vendedor.getProducto());
        v.setTotalVendido(vendedor.getTotalVendido());
        v.setSueldo(vendedor.getSueldo());
        return service.save(v);
    }
}
