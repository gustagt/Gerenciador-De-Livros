package com.backend.crm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LivrosAr {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLivro;
    
    @Column(nullable = false)
    private String nomeLivro;
    
    private String detalhes;
    
    private String dataCadastro ;
    
    @Column(nullable = false)
    private String autor;
    
    private Integer idCadastrante;

    public Integer getIdCadastrante() {
        return this.idCadastrante;
    }

    public void setIdCadastrante(Integer idCadastrante) {
        this.idCadastrante = idCadastrante;
    }

    public Integer getIdLivro() {
        return this.idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLivro() {
        return this.nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getDetalhes() {
        return this.detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
