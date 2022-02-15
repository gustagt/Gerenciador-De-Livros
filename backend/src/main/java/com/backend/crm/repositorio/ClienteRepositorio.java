package com.backend.crm.repositorio;



import com.backend.crm.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio  extends JpaRepository<Cliente, Long>{
    
}
