package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro")
@Data
public class Livro {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero ", nullable = false, length = 30)
    private GeneroLivro genero;

    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco;


    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", dataPublicao=" + dataPublicao +
                ", genero=" + genero +
                ", preco=" + preco +
                ", autor=" + autor +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "id_autor" )
    private Autor autor;


}
