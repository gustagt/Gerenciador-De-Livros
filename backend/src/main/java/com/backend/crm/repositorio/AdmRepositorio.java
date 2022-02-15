package com.backend.crm.repositorio;

import com.backend.crm.model.Adm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmRepositorio extends JpaRepository<Adm,Long>{
    
}
