package com.draft82.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.draft82.api.model.GameSession;
import com.draft82.api.repository.GameSessionRepository;

@Service
public class GameService {

    @Autowired
    private GameSessionRepository gameRepository;

    // Tradução do método iniciarNovoDraft() do seu diagrama UML
    public GameSession iniciarNovoDraft() {
        GameSession novaSessao = new GameSession();
        novaSessao.setRodadaAtual(1);
        novaSessao.setStatus("EM_ANDAMENTO");
        novaSessao.setTemporadaPerfeita(false);
        
        return gameRepository.save(novaSessao);
    }
}