package com.draft82.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.draft82.api.model.GameSession;
import com.draft82.api.service.GameService;

@RestController
@RequestMapping("/jogos")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/iniciar")
    public GameSession iniciarJogo() {
        return gameService.iniciarNovoDraft();
    }
}