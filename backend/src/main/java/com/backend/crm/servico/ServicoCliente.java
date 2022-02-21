package com.backend.crm.servico;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.backend.crm.exceptions.CriptoExistExeception;
import com.backend.crm.exceptions.NomeUsuarioExistExeception;
import com.backend.crm.exceptions.ServicoException;
import com.backend.crm.model.Cliente;
import com.backend.crm.model.LivrosAr;
import com.backend.crm.repositorio.ClienteRepositorio;
import com.backend.crm.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoCliente {

    @Autowired
    private ClienteRepositorio cRepositorio;

    public void salvarCliente(Cliente cliente) throws Exception{
        try {
            
            if(cRepositorio.findByNomeUsuario(cliente.getNomeUsuario()) != null){
                throw new NomeUsuarioExistExeception("Nome de Usuario ja cadastrado.");
            }
            cliente.setSenha(Util.md5(cliente.getSenha()));

        } catch (NoSuchAlgorithmException e) {
            throw new  CriptoExistExeception("Erro na criptogradia da senha:");
        }

        cRepositorio.save(cliente);

    }
    
    public Cliente logCliente(String user, String senha) throws ServicoException{

        Cliente clienteLogin = cRepositorio.buscarLogin(user, senha);
        return clienteLogin;
    }

    public List<LivrosAr> livrosCliente(Integer id){
        Cliente cliente = cRepositorio.findById(id).get();
        return cliente.getLivrosCliente();
    }
}
