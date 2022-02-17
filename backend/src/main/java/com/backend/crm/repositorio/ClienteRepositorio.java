package com.backend.crm.repositorio;

import com.backend.crm.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio  extends JpaRepository<Cliente, Long>{

    @Query("select a from Cliente a where a.nomeUsuario = :nomeUsuario")
    public Cliente findByNomeUsuario(String nomeUsuario);

    @Query("select b from Cliente b where b.nomeUsuario = :nomeUsuario and b.senha = :senha")
    public Cliente buscarLogin(String nomeUsuario, String senha);
    
}
