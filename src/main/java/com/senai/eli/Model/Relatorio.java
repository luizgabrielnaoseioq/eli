package com.senai.eli.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "relatorio_evento",
    joinColumns = @JoinColumn(name = "relatorio_id"),
    inverseJoinColumns = @JoinColumn(name = "evento_id"))
    private List<Evento> eventos = new ArrayList<>();
}
