package com.backend.crm.servico;

import com.backend.crm.exceptions.ServicoException;
import com.backend.crm.model.Adm;
import com.backend.crm.repositorio.AdmRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoAdm {
    
    @Autowired
    private AdmRepositorio admRepositorio;

    
    public Adm loginAdm(String user, String senha) throws ServicoException{

        Adm admLogin = admRepositorio.buscarLogin(user, senha);
        return admLogin;
    }
}
