package com.backend.crm.repositorio;

import com.backend.crm.model.LivrosAr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepositorio extends JpaRepository<LivrosAr, Long>{
    
}
