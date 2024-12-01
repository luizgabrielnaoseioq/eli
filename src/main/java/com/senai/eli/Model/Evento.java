package com.senai.eli.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "evento")
@Entity
@Getter
@Setter
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 10, max = 200)
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "ip")
    private String ip;

    @Column(name = "valor")
    @ColumnDefault("0")
    private double valor = 0;

    @Column(name = "banner")
    private String banner;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "nome")
    private String nome;

    @Column(name = "aprovado")
    @ColumnDefault("false")
    private boolean aprovado = false;

    @Column(name = "indexador")
    private String indexador;

    @Column(name = "responsavel")
    private String responsavel;

    @Column(name = "cronograma")
    private String cronograma;

    @ManyToMany
    @JoinTable(name = "evento_calendario")
    private List<Calendario> calendarios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToMany
    @JoinTable(name = "evento_grupo")
    private List<GrupoTrabalho> grupos = new ArrayList<>();

    @ManyToMany(mappedBy = "eventos")
    private List<Relatorio> relatorios = new ArrayList<>();

    @ManyToMany(mappedBy = "eventos")
    private List<Usuario> usuarios = new ArrayList<>();
}