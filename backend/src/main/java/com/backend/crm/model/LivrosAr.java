package com.backend.crm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LivrosAr {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLivro;
    
    @Column(nullable = false)
    private String nomeLivro;
    
    private String detalhes;
    
    @Column(nullable = false)
    private Date dataCadastro ;
    
    @Column(nullable = false)
    private String autor;
    
    @ManyToOne
    private Cliente cliente;

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getIdLivro() {
        return this.idLivro;
    }

    public void setIdLivro(long idLivro) {
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

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
