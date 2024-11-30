package com.senai.eli.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "categoria")
@Table
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;
}
