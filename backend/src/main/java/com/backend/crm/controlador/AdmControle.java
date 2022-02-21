package com.backend.crm.controlador;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.backend.crm.exceptions.CriptoExistExeception;
import com.backend.crm.exceptions.ServicoException;
import com.backend.crm.model.Adm;
import com.backend.crm.model.RespostaLogin;
import com.backend.crm.repositorio.AdmRepositorio;
import com.backend.crm.servico.ServicoAdm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
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
    public RespostaLogin login(@RequestBody Adm adm, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServicoException, CriptoExistExeception{
        RespostaLogin retornoLogin = new RespostaLogin();
        
        if(br.hasErrors()){
            retornoLogin.setRetorno("Usuario ou senha invalido");
        }

        Adm admLogin = admServico.loginAdm(adm.getNomeUsuario(), adm.getSenha());
        if(admLogin==null){
            throw new CriptoExistExeception("Deu ruim"); 
        }else{
            session.setAttribute("UsuarioLogado", admLogin);
            retornoLogin.setRetorno("true");
        }
        
        return retornoLogin;
    }   
}
