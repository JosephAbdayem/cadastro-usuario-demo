package com.cadastrousuariodemo.controllers;

import com.cadastrousuariodemo.model.Usuario;
import com.cadastrousuariodemo.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Usuario usuario;

    @Before
    public void clearRepository() {
        usuarioRepository.deleteAll();
    }

    @Before
    public void setUp() {
        usuario = new Usuario("Fulano de Tal", "fulano@gmail.com", LocalDate.of(1995, 1, 1), "Rua Teste 123", Collections.emptyList());
        usuarioRepository.save(usuario);
    }

    @Test
    public void findAllDeveRetornarListaComUmUsuario() throws Exception {
        mockMvc.perform(get("/api/usuarios")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].id", is(usuario.getId().intValue()))).andExpect(jsonPath("$[0].nome", is(usuario.getNome()))).andExpect(jsonPath("$[0].email", is(usuario.getEmail()))).andExpect(jsonPath("$[0].dataNascimento", is(usuario.getDataNascimento().toString()))).andExpect(jsonPath("$[0].endereco", is(usuario.getEndereco()))).andExpect(jsonPath("$[0].habilidades", hasSize(0)));
    }

    @Test
    public void findByIdDeveRetornarUsuarioComIdCorrespondente() throws Exception {
        mockMvc.perform(get("/api/usuarios/{id}", usuario.getId())).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(usuario.getId().intValue()))).andExpect(jsonPath("$.nome", is(usuario.getNome()))).andExpect(jsonPath("$.email", is(usuario.getEmail()))).andExpect(jsonPath("$.dataNascimento", is(usuario.getDataNascimento().toString()))).andExpect(jsonPath("$.endereco", is(usuario.getEndereco()))).andExpect(jsonPath("$.habilidades", hasSize(0)));
    }

    @Test
    public void findByIdDeveRetornarNotFoundParaIdInexistente() throws Exception {
        mockMvc.perform(get("/api/usuarios/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    public void createDeveRetornarUsuarioCriado() throws Exception {
        Usuario novoUsuario = new Usuario("Beltrano de Tal", "beltrano@gmail.com", LocalDate.of(1990, 1, 1), "Rua Teste 456", Collections.emptyList());
        mockMvc.perform(post("/api/usuarios").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(novoUsuario))).andExpect(status().isCreated()).andExpect(jsonPath("$.id", notNullValue())).andExpect(jsonPath("$.nome", is(novoUsuario.getNome()))).andExpect(jsonPath("$.email", is(novoUsuario.getEmail()))).andExpect(jsonPath("$.dataNascimento", is(novoUsuario.getDataNascimento().toString()))).andExpect(jsonPath("$.endereco", is(novoUsuario.getEndereco()))).andExpect(jsonPath("$.habilidades", hasSize(0)));
    }

    @Test
    public void updateDeveRetornarUsuarioAtualizado() throws Exception {
        Usuario usuarioAtualizado = new Usuario("Fulano de Tal Silva", "fulano@gmail.com", LocalDate.of(1995, 1, 1), "Rua Teste 123", Collections.emptyList());
        mockMvc.perform(put("/api/usuarios/{id}", usuario.getId()).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(usuarioAtualizado))).andExpect(status().isOk()).andExpect(jsonPath("$.id", is(usuario.getId().intValue()))).andExpect(jsonPath("$.nome", is(usuarioAtualizado.getNome()))).andExpect(jsonPath("$.email", is(usuarioAtualizado.getEmail()))).andExpect(jsonPath("$.dataNascimento", is(usuarioAtualizado.getDataNascimento().toString()))).andExpect(jsonPath("$.endereco", is(usuarioAtualizado.getEndereco()))).andExpect(jsonPath("$.habilidades", hasSize(0)));
    }

    @Test
    public void updateDeveRetornarNotFoundParaIdInexistente() throws Exception {
        Usuario usuarioAtualizado = new Usuario("Fulano de Tal Silva", "fulano@gmail.com", LocalDate.of(1995, 1, 1), "Rua Teste 123", Collections.emptyList());
        mockMvc.perform(put("/api/usuarios/{id}", Long.MAX_VALUE).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(usuarioAtualizado))).andExpect(status().isNotFound());
    }

    @Test
    public void deleteByIdDeveRemoverUsuarioComIdCorrespondente() throws Exception {
        mockMvc.perform(delete("/api/usuarios/{id}", usuario.getId())).andExpect(status().isNoContent());

        mockMvc.perform(get("/api/usuarios/{id}", usuario.getId())).andExpect(status().isNotFound());
    }

    @Test
    public void deleteByIdDeveRetornarNotFoundParaIdInexistente() throws Exception {
        mockMvc.perform(delete("/api/usuarios/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
