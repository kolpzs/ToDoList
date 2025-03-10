package com.pin.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "itens")
@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column
    private Date data;

    @Column(columnDefinition = "boolean default false")
    private boolean favorito;

    @Column(columnDefinition = "boolean default false")
    private boolean feita;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    @JsonIgnoreProperties({"users", "grupos", "itens", "eventos"})
    private GrupoEntity grupo;
}
