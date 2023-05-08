package com.cadastrousuariodemo.repositories;

import com.cadastrousuariodemo.model.Habilidade;
import com.cadastrousuariodemo.model.Usuario;
import com.cadastrousuariodemo.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    public void setUp() {
        Habilidade habilidade1 = new Habilidade("Programação Java", "Dev Java Top");
        Habilidade habilidade2 = new Habilidade("Programação Python", "Dev Java Top");
        Habilidade habilidade3 = new Habilidade("Programação C#", "Dev Java Top");

        usuario1 = new Usuario("Fulano", "fulano@gmail.com", LocalDate.of(1990, 1, 1), "Rua 1", Arrays.asList(habilidade1, habilidade2));
        usuario2 = new Usuario("Ciclano", "ciclano@hotmail.com", LocalDate.of(1985, 6, 15), "Rua 2", Arrays.asList(habilidade3));

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
    }

    @Test
    public void testFindAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        assertThat(usuarios).hasSize(2);
        assertThat(usuarios).contains(usuario1, usuario2);
    }

    @Test
    public void testFindById() {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(usuario1.getId());
        assertThat(usuarioEncontrado.isPresent()).isTrue();
        assertThat(usuarioEncontrado.get()).isEqualTo(usuario1);
    }

    @Test
    public void testFindByIdNotFound() {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(999L);
        assertThat(usuarioEncontrado.isPresent()).isFalse();
    }

    @Test
    public void testDeleteById() {
        usuarioRepository.deleteById(usuario1.getId());
        List<Usuario> usuarios = usuarioRepository.findAll();
        assertThat(usuarios).hasSize(1);
        assertThat(usuarios).contains(usuario2);
    }
}
