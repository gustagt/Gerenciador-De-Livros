package com.backend.crm.controlador;

import java.util.List;

import com.backend.crm.model.Adm;
import com.backend.crm.repositorio.AdmRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Adm")
public class AdmControle {

    @Autowired
    private AdmRepositorio admRepositorio;

    @GetMapping
    public List<Adm> listar(){
        return admRepositorio.findAll();
    }

    
}
