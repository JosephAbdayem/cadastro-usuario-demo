package com.cadastrousuariodemo.models;// UsuarioTest.java

import com.cadastrousuariodemo.model.Habilidade;
import com.cadastrousuariodemo.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UsuarioTest {

    private Usuario usuario;
    private Habilidade habilidade1;
    private Habilidade habilidade2;

    @BeforeEach
    public void setUp() {
        habilidade1 = new Habilidade("Java", "Linguagem de programação");
        habilidade2 = new Habilidade("Python", "Linguagem de programação");

        List<Habilidade> habilidades = new ArrayList<>();
        habilidades.add(habilidade1);

        usuario = new Usuario("Joao Silva", "joaosilva@gmail.com", LocalDate.of(1995, 6, 15), "Rua das Flores 123", habilidades);
    }

    @Test
    public void testEquals() {
        habilidade1 = new Habilidade("Java", "Linguagem de programação");
        habilidade2 = new Habilidade("Python", "Linguagem de programação");

        List<Habilidade> habilidades = new ArrayList<>();
        habilidades.add(habilidade1);

        Usuario usuario = new Usuario("Joao Silva", "joaosilva@gmail.com", LocalDate.of(1995, 6, 15), "Rua das Flores 123", new ArrayList<>());
        usuario.setId(1L);

        Usuario usuario2 = new Usuario("Joao Silva", "joaosilva@gmail.com", LocalDate.of(1995, 6, 15), "Rua das Flores 123", new ArrayList<>());
        usuario2.setId(1L);

        assertEquals(usuario, usuario2, "Os usuários devem ser iguais.");
    }


    @Test
    public void testNotEquals() {
        Usuario usuario2 = new Usuario("Maria Santos", "mariasantos@gmail.com", LocalDate.of(1990, 8, 10), "Rua das Flores 123", new ArrayList<>());
        usuario2.setId(2L);
        usuario.setId(1L);
        assertNotEquals(usuario, usuario2, "Os usuários não devem ser iguais.");
    }

    @Test
    public void testToString() {
        String expected = "Usuario{id=1, nome='Joao Silva', email='joaosilva@gmail.com', dataNascimento=1995-06-15, endereco='Rua das Flores 123', habilidades=[Habilidade{id=null, nome='Java', descricao='Linguagem de programação'}]}";
        usuario.setId(1L);
        assertEquals(expected, usuario.toString(), "A representação em String do usuário deve ser igual ao esperado.");
    }
}
