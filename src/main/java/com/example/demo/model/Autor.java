package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

//obrigatório para sinalizar que esta sendo feito um mapeamento de uma entidade para o JPA
@Entity
@Table(name = "autor")
@Getter
@Setter
public class Autor {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNacimento;

    @Column(name = "nacionalidade", nullable = false, length = 50)
    private String nacionalidade;

    @Deprecated
    public Autor(){
        //para uso do framweork é obrigatório o uso de um construtor
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNacimento=" + dataNacimento +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", livros=" + livros +
                '}';
    }

    //@OneToMany(mappedBy = "autor")
    @Transient
    private List<Livro> livros;



}
