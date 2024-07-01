package com.ipn.mx.model.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del cliente es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre del cliente debe tener entre 3 y 100 caracteres")
    @Column(name = "nombreCliente", length = 100, nullable = false)
    private String nombreCliente;

    @Size(max = 250, message = "La dirección no puede tener más de 250 caracteres")
    @Column(name = "direccion", length = 250)
    private String direccion;

    @Size(max = 20, message = "El teléfono no puede tener más de 20 caracteres")
    @Column(name = "telefono", length = 20)
    private String telefono;

    @Email(message = "Debe ser una dirección de correo electrónico válida")
    @Size(max = 100, message = "El correo electrónico no puede tener más de 100 caracteres")
    @Column(name = "email", length = 100)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Vendedor vendedor;
}
