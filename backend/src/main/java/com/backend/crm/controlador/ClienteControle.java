package com.backend.crm.controlador;


import java.util.List;

import com.backend.crm.model.Cliente;
import com.backend.crm.repositorio.ClienteRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class ClienteControle {

    @Autowired
    private ClienteRepositorio clienteRepositorio;
    
    @GetMapping
    public List<Cliente> listar(){
        return clienteRepositorio.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)    
    public Cliente adicionar(@RequestBody Cliente cliente){
        return clienteRepositorio.save(cliente);
    }

     
}
