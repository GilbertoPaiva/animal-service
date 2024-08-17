package br.com.gpaiva.animalservice.entidades;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidade que representa um funcionário.
 */
@Data
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nome;
}