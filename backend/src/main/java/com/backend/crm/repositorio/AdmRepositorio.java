package com.backend.crm.repositorio;

import com.backend.crm.model.Adm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRepositorio extends JpaRepository<Adm,Long>{
    
    @Query("select a from Adm a where a.nomeUsuario = :nomeUsuario and a.senha = :senha")
    public Adm buscarLogin(String nomeUsuario, String senha);
    
}
