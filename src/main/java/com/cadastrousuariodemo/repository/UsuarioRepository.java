package com.cadastrousuariodemo.repository;

import com.cadastrousuariodemo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface de Repositório de Usuários que estende JpaRepository.
 *
 * Implementa os métodos básicos de CRUD e consultas personalizadas.
 *
 * Aplica os princípios de Clean Code e SOLID.
 *
 * @author Autor
 * @version 1.0
 * @since 2023-05-08
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Retorna uma lista com todos os usuários.
     *
     * @return List<Usuario> - lista de usuários
     */
    List<Usuario> findAll();

    /**
     * Retorna um Optional contendo um usuário a partir do ID informado.
     *
     * @param id Long - ID do usuário
     * @return Optional<Usuario> - usuário encontrado, se presente
     */
    Optional<Usuario> findById(Long id);

    /**
     * Remove um usuário a partir do ID informado.
     *
     * @param id Long - ID do usuário
     */
    void deleteById(Long id);
}