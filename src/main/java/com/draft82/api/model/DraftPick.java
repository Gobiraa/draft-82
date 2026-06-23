package com.draft82.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "draft_pick")
@Data
public class DraftPick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String posicaoSelecionada;

    @ManyToOne // mais de uma sessão pode escolher o mesmo jogador
    @JoinColumn(name = "player_decade_id")
    private PlayerDecade jogador;

    @ManyToOne
    @JoinColumn(name = "game_session_id")
    private GameSession gameSession;

    
}
