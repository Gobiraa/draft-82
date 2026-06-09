package com.draft82.api.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "player_decade")
@Data
public class PlayerDecade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_decade_id") // nome da FK
    private TeamDecade teamDecade; 

    private String nome;
    @Column(name = "posicoes_validas")
    private String posicoesValidas; //ex: SF, PG, PF

    private double pontos;
    private double assistencias;
    private double rebotes;
    private double roubos;
    private double tocos;
    private double turnovers;
    private int overallCalculado;
    
}
