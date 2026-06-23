package com.draft82.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "game_session")
@Data
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id; //UUID ao inves de um Long Sequencial para evitar quem alguem invada outra sessão

    private int rodadaAtual;
    private String status;
    private String recordeFinal;
    private boolean temporadaPerfeita;

    @OneToMany(mappedBy = "gameSession")
    private List<DraftPick> escolhas;

}
