package com.backend.crm.controlador;


import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.backend.crm.exceptions.ServicoException;
import com.backend.crm.model.Cliente;
import com.backend.crm.repositorio.ClienteRepositorio;
import com.backend.crm.servico.ServicoCliente;
import com.backend.crm.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cliente")
public class ClienteControle {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ServicoCliente sCliente;
    
    @GetMapping("/listar")
    public List<Cliente> listar(){
        return clienteRepositorio.findAll();
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)    
    public String cadastrarCliente(@RequestBody Cliente cliente) throws Exception{
        sCliente.salvarCliente(cliente);
        return "sucesso";
    }

    @PostMapping("/login")
    public String login(@RequestBody Cliente cliente, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServicoException{
        String teste="sucess";
        if(br.hasErrors()){
            teste="deuruim";
        }

        Cliente clienteLogin = sCliente.logCliente(cliente.getNomeUsuario(), Util.md5(cliente.getSenha()));

        if(clienteLogin==null){
            teste="Usuario não encontrado";
        }else{
            session.setAttribute("UsuarioLogado", clienteLogin);
            teste="sucesso";
        }
        return teste;
    }

     
}
