package com.ipn.mx.model.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name="categoria")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre de la categoría debe tener entre 3 y 100 caracteres")
    @Column(name = "nombreCategoria", length = 100, nullable = false)
    private String nombreCategoria;

    @Size(max = 250, message = "La descripción de la categoría no puede tener más de 250 caracteres")
    @Column(name = "descripcionCategoria", length = 250)
    private String descripcionCategoria;
}
