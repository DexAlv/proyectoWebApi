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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "vendedores")
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del empleado es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre del empleado debe tener entre 3 y 100 caracteres")
    @Column(name = "nombreEmpleado", length = 100, nullable = false)
    private String nombreEmpleado;

    @NotBlank(message = "El número de empleado es obligatorio")
    @Size(max = 20, message = "El número de empleado no puede tener más de 20 caracteres")
    @Column(name = "numeroEmpleado", length = 20, nullable = false)
    private String numeroEmpleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @NotNull(message = "El total vendido es obligatorio")
    @Min(value = 0, message = "El total vendido no puede ser negativo")
    @Column(name = "totalVendido", nullable = false)
    private Double totalVendido;

    @NotNull(message = "El sueldo es obligatorio")
    @Min(value = 0, message = "El sueldo no puede ser negativo")
    @Column(name = "sueldo", nullable = false)
    private Double sueldo;
}
