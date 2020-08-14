package br.gama.projagenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.gama.projagenda.model.Agendamento;
import br.gama.projagenda.dao.AgendamentoDAO;

@RestController
@CrossOrigin("*")
public class AgendamentoController {
    
    @Autowired
    private AgendamentoDAO dao;

    @GetMapping("/agendamento")
    public List<Agendamento> getAgencias(){
        final List<Agendamento> lista = (List<Agendamento>) dao.findAll();
        return lista;
    }

    @PostMapping("/agendamento/novo")
    public ResponseEntity<Agendamento> novoUsuario(@RequestBody final Agendamento agendamen){
        
        //tente fazer a inserção/atualização
        try {
            final Agendamento novo =  dao.save(agendamen);
            return ResponseEntity.ok(novo);
        } catch (final Exception e) { //se der errado, retorne o erro
            return ResponseEntity.status(400).build(); //bat request
        }
    }

}