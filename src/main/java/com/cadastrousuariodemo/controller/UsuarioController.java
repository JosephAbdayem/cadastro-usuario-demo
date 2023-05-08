package com.cadastrousuariodemo.controller;

import com.cadastrousuariodemo.model.Usuario;
import com.cadastrousuariodemo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Classe controladora de Usuários.
 *
 * Aplica os princípios de Clean Code e SOLID.
 *
 * @version 1.0
 * @since 2023-05-08
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Retorna todos os usuários.
     *
     * @return ResponseEntity<List<Usuario>> - lista de usuários
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
          return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    /**
     * Retorna um usuário a partir do ID informado.
     *
     * @param id Long - ID do usuário
     * @return ResponseEntity<Usuario> - usuário encontrado, se presente
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Cria um novo usuário.
     *
     * @param usuario Usuario - usuário a ser criado
     * @return ResponseEntity<Usuario> - usuário criado
     */
    @PostMapping
    public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    /**
     * Atualiza um usuário a partir do ID informado.
     *
     * @param id Long - ID do usuário
     * @param usuario Usuario - usuário a ser atualizado
     * @return ResponseEntity<Usuario> - usuário atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            usuario.setId(id);
            return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Remove um usuário a partir do ID informado.
     *
     * @param id Long - ID do usuário
     * @return ResponseEntity<Void> - status da operação
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
