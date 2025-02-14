package com.senai.eli.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import com.senai.eli.Enum.Sexo;
import com.senai.eli.Validator.Telefone.Telefone;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Table(name = "usuario")
@Entity
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "sexo", nullable = false)
    @ColumnDefault("3")
    private Sexo sexo = Sexo.NAO_INFORMADO;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(name = "telefone", length = 15)
    @Telefone(apenasCelular = true, required = false)
    private String telefone;

    @Column(name = "nascimento", nullable = false)
    private LocalDate nascimento;

    @ManyToMany
    @JoinTable(
            name = "usuario_evento",
            joinColumns = @JoinColumn(name = "usuario-id"),
            inverseJoinColumns = @JoinColumn(name = "evento-id")
    )
    private List<Event> events = new ArrayList<>();
}
