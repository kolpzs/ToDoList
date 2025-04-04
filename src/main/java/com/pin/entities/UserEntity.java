package com.pin.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

    @Min(0)
    @Max(3)
    @Column(nullable = false, columnDefinition = "int default 0")
    private int tentativas;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"users", "grupos", "itens", "eventos", "users"})
    private List<GrupoEntity> grupos;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"users", "grupos", "itens", "eventos", "users"})
    private List<ItemEntity> itens;

    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties({"users", "grupos", "itens", "eventos", "equipes"})
    private List<EventoEntity> eventos;
}
