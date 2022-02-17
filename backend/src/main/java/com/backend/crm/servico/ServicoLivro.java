package com.backend.crm.servico;

import com.backend.crm.exceptions.NomeLivroExistExeception;
import com.backend.crm.model.LivrosAr;
import com.backend.crm.repositorio.LivrosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoLivro {

    @Autowired
    private LivrosRepositorio lRepositorio;

    public void salvarLivro(LivrosAr livro) throws Exception {

        if (lRepositorio.findByNomeLivro(livro.getNomeLivro()) != null) {
            throw new NomeLivroExistExeception("Livro ja cadastrado.");
        }

        lRepositorio.save(livro);

    }

}
