package com.senai.eli.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "relatorio")
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "invacao")
    private String invacao;
}
