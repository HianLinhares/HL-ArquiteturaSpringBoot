package com.example.demo;

import com.example.demo.model.Autor;
import com.example.demo.model.GeneroLivro;
import com.example.demo.model.Livro;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class LivroRepositoryTest {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    void salvarTest() {
        Livro livro = new Livro();
        livro.setIsbn("11111111");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.ROMANCE);
        livro.setTitulo("UFO");
        livro.setDataPublicao(LocalDate.of(2010, 02, 01));
        Autor autor = autorRepository.findById(UUID.fromString("c2cb386c-ad50-437b-a4c1-a70de441366b")).orElse(null);
        livro.setAutor(autor);
        livroRepository.save(livro);
    }


    @Test
    void pesquisaPorTituloTest() {
        List<Livro> lista = livroRepository.findByTitulo("UFO");
        lista.forEach(System.out::println);
    }


}
