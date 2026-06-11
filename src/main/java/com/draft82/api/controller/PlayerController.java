package com.draft82.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.draft82.api.model.PlayerDecade;
import com.draft82.api.repository.PlayerRepository;

@RestController //Retorno de dados (Json)
@RequestMapping("/jogadores") //define que o acesso sera pelo 8080/jogadores
public class PlayerController {

    @Autowired //injeta o repositorio e permite o findAll
    private PlayerRepository repository;

    @GetMapping //procura todos os jogadores
    public List<PlayerDecade> listarTodos() {
        return repository.findAll();
    }

    @PostMapping //envia a requisição para o postman
    public PlayerDecade cadastrar(@RequestBody PlayerDecade jogador) {
        return repository.save(jogador);
    }
}