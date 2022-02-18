package com.backend.crm.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.backend.crm.model.Id;
import com.backend.crm.model.LivrosAr;
import com.backend.crm.repositorio.LivrosRepositorio;
import com.backend.crm.servico.ServicoLivro;


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
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
    
    

    @Autowired
    private LivrosRepositorio livrosRepositorio;

    @Autowired
    private ServicoLivro servicoLivro;
  

    @GetMapping("/listar")
    public List<LivrosAr> listar(){
        return livrosRepositorio.findAll();
    }

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)    
    public String cadastrarLivro(@RequestBody LivrosAr livro) throws Exception{
        String dt= formato.format(new Date());
        livro.setDataCadastro(dt);
        servicoLivro.salvarLivro(livro, livro.getIdCadastrante());
        return "sucesso";
    }

    @PostMapping("/cadastrarAdm")
    @ResponseStatus(HttpStatus.CREATED)    
    public String cadastrarLivroAdm(@RequestBody LivrosAr livro) throws Exception{
        String dt= formato.format(new Date());
        livro.setDataCadastro(dt);
        servicoLivro.salvarLivroAdm(livro, livro.getIdCadastrante());
        return "sucesso";
    }

    @PostMapping("/remover")
    public String removerLivro(@RequestBody Id id) {
        LivrosAr livro = servicoLivro.getLivroById(id.getId());
        servicoLivro.remover(livro);

        return "sucess";
    }

    @GetMapping("/editar")
    public LivrosAr receberLivro(@RequestBody Id id) {
      
        return  servicoLivro.getLivroById(id.getId());
    }

    @PostMapping("/editarSave")
    public void salvarEdicao(@RequestBody LivrosAr livro) throws Exception {
        servicoLivro.salvarLivro(livro, livro.getIdCadastrante());
    }

    
}
