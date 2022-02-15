package com.backend.crm.controlador;

import java.util.List;

import com.backend.crm.model.LivrosAr;
import com.backend.crm.repositorio.LivrosRepositorio;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivrosControle {

    @Autowired
    private LivrosRepositorio livrosRepositorio;

    @GetMapping
    public List<LivrosAr> listar(){
        return livrosRepositorio.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)    
    public LivrosAr adicionar(@RequestBody LivrosAr livro){
        return livrosRepositorio.save(livro);
    }

    
}
