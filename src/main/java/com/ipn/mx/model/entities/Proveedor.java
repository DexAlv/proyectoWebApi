package com.ipn.mx.model.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    @Size(min = 5, max = 100, message = "El nombre del proveedor debe tener entre 5 y 100 caracteres")
    @Column(name = "nombreProveedor", length = 100, nullable = false)
    private String nombreProveedor;

    @Size(max = 20, message = "El número de teléfono no puede tener más de 20 caracteres")
    @Column(name = "numeroTelefono", length = 20)
    private String numeroTelefono;

    @Email(message = "Debe ser una dirección de correo electrónico válida")
    @Size(max = 100, message = "El correo electrónico no puede tener más de 100 caracteres")
    @Column(name = "email", length = 100)
    private String email;
}
