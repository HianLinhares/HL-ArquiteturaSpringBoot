package com.example.demo;

import com.example.demo.model.Autor;
import com.example.demo.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@SpringBootTest
public class AutorRepositoryTest {


    @Autowired
    AutorRepository repository;


    @Test
    public void adicionarAutor() {
        Autor autor = new Autor();
        autor.setNome("Bruno");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNacimento(LocalDate.of(1950, 02, 02));
        var autosalvo = repository.save(autor);
        System.out.println("autor salvo");
    }

    @Test
    public void atualizarTest() {
        var id = UUID.fromString("9a8b9712-00bf-412c-b5bb-61216b1ba8d6");
        Optional<Autor> possivelAutor = repository.findById(id);

        if (possivelAutor.isPresent()) {

            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do autor: ");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNacimento(LocalDate.of(2001, 2, 02));
            repository.save(autorEncontrado);
        }
    }

    @Test
    public void listarTeste() {
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    public void countTest() {
        System.out.println("CONTAGEM DE USUÁRIOS PRESENTES NO BANCO DE DADOS: " + repository.count());
    }

    @Test
    public void deleteporIdTest() {
        var id = UUID.fromString("c2cb386c-ad50-437b-a4c1-a70de441366b");
        repository.deleteById(id);
    }

    @Test
    public void deleteporObject() {
        var id = UUID.fromString("c2cb386c-ad50-437b-a4c1-a70de441366b");
        var maria = repository.findById(id).get();
        repository.delete(maria);
    }


}
