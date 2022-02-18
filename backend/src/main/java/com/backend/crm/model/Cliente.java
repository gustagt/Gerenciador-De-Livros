package com.backend.crm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nomeUsuario;

    @Column(nullable = false)
    private String senha;

    @OneToMany
    @JoinColumn(name = "idCliente")
    private List<LivrosAr> livrosCliente;

    public void addLivro(LivrosAr livro){
        this.livrosCliente.add(livro);
    }

    public List<LivrosAr> getLivrosCliente() {
        return this.livrosCliente;
    }

    public void setLivrosCliente(List<LivrosAr> livrosCliente) {
        this.livrosCliente = livrosCliente;
    }
 
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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