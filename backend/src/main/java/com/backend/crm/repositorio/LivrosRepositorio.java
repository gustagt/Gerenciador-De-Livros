package com.backend.crm.repositorio;

import com.backend.crm.model.LivrosAr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepositorio extends JpaRepository<LivrosAr, Long>{
    
    @Query("select a from LivrosAr a where a.nomeLivro = :nomeLivro")
    public LivrosAr findByNomeLivro(String nomeLivro);

}
