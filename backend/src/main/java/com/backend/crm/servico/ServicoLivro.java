package com.backend.crm.servico;

import com.backend.crm.exceptions.NomeLivroExistExeception;
import com.backend.crm.model.Adm;
import com.backend.crm.model.Cliente;
import com.backend.crm.model.LivrosAr;
import com.backend.crm.repositorio.AdmRepositorio;
import com.backend.crm.repositorio.ClienteRepositorio;
import com.backend.crm.repositorio.LivrosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoLivro {

    @Autowired
    private LivrosRepositorio lRepositorio;

    @Autowired
    private ClienteRepositorio cRepositorio;

    @Autowired
    private AdmRepositorio admRepositorio;

    public void salvarLivro(LivrosAr livro, Integer id) throws Exception {

        if (lRepositorio.findByNomeLivro(livro.getNomeLivro()) != null) {
            throw new NomeLivroExistExeception("Livro ja cadastrado.");
        }
        

        lRepositorio.save(livro);
        Cliente cliente = cRepositorio.findById(id).get();
        cliente.addLivro(livro);
        cRepositorio.save(cliente);
    }

    public void salvarLivroAdm(LivrosAr livro, Integer id) throws Exception {

        if (lRepositorio.findByNomeLivro(livro.getNomeLivro()) != null) {
            throw new NomeLivroExistExeception("Livro ja cadastrado.");
        }
        

        lRepositorio.save(livro);
        Adm adm = admRepositorio.findById(id).get();
        adm.addLivro(livro);
        admRepositorio.save(adm);
    }

    public LivrosAr getLivroById(Integer id) {
        return lRepositorio.findById(id).get();
    }

    public void remover(LivrosAr livro) {
        lRepositorio.delete(livro);
    }

    public void editarLivro(LivrosAr livro)  {
        lRepositorio.save(livro);
    }

}
