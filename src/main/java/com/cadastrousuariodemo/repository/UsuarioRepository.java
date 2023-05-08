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
 * @version 1.0
 * @since 2023-05-08
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Retorna uma lista com todos os usuários.
     *
     * @return a lista de usuários encontrados
     */
    List<Usuario> findAll();

    /**
     * Busca um usuário pelo seu ID.
     *
     * @param id o ID do usuário a ser buscado
     * @return um Optional contendo o usuário encontrado (se presente)
     */
    Optional<Usuario> findById(Long id);

    /**
     * Deleta um usuário pelo seu ID.
     *
     * @param id o ID do usuário a ser deletado
     */
    void deleteById(Long id);
}
