package com.backend.crm.controlador;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.backend.crm.exceptions.ServicoException;
import com.backend.crm.model.Adm;
import com.backend.crm.repositorio.AdmRepositorio;
import com.backend.crm.servico.ServicoAdm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adm")
public class AdmControle {

    @Autowired
    private AdmRepositorio admRepositorio;

    @Autowired
    private ServicoAdm admServico;

    @GetMapping
    public List<Adm> listar(){
        return admRepositorio.findAll();
    }

    @PostMapping("/login")
    public String login(@RequestBody Adm adm, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServicoException{
        String teste="sucess";
        if(br.hasErrors()){
            teste="deuruim";
        }

        Adm admLogin = admServico.logAdm(adm.getNomeUsuario(), adm.getSenha());

        if(admLogin==null){
            teste="Usuario não encontrado";
        }else{
            session.setAttribute("UsuarioLogado", admLogin);
            teste="sucesso";
        }
        return teste;
    }

    
}
