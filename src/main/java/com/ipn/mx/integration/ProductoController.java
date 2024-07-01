package com.ipn.mx.integration;

import com.ipn.mx.model.entities.Producto;
import com.ipn.mx.services.ProductoService;

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
@RequestMapping("/apiProductos")
public class ProductoController {
    @Autowired
    ProductoService service;

    @GetMapping("/productos")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Producto> mostrarProductos() {
        return service.findAll();
    }

    @GetMapping("/productos/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Producto mostrarProducto(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/productos")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Producto crearProducto(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @DeleteMapping("/productos/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("/productos/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Producto actualizarProducto(@RequestBody Producto producto, @PathVariable Long id) {
        Producto p = service.findById(id);
        p.setNombreProducto(producto.getNombreProducto());
        p.setDescripcionProducto(producto.getDescripcionProducto());
        p.setCantidadEnExistencia(producto.getCantidadEnExistencia());
        p.setPrecio(producto.getPrecio());
        p.setCategoria(producto.getCategoria());
        p.setProveedor(producto.getProveedor());
        return service.save(p);
    }
}
