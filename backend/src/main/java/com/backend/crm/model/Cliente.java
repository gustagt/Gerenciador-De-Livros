package com.backend.crm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nomeUsuario;

    @Column(nullable = false)
    private String senha;

    @OneToMany
    private List<LivrosAr> livrosCliente;


    public List<LivrosAr> getLivrosCliente() {
        return this.livrosCliente;
    }

    public void setLivrosCliente(List<LivrosAr> livrosCliente) {
        this.livrosCliente = livrosCliente;
    }
 
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}