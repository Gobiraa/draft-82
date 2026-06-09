package com.draft82.api.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "player_decade")
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamDecade getTeamDecade() {
        return teamDecade;
    }

    public void setTeamDecade(TeamDecade teamDecade) {
        this.teamDecade = teamDecade;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicoesValidas() {
        return posicoesValidas;
    }

    public void setPosicoesValidas(String posicoes_validas) {
        this.posicoesValidas = posicoes_validas;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    public double getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(double assistencias) {
        this.assistencias = assistencias;
    }

    public double getRebotes() {
        return rebotes;
    }

    public void setRebotes(double rebotes) {
        this.rebotes = rebotes;
    }

    public double getRoubos() {
        return roubos;
    }

    public void setRoubos(double roubos) {
        this.roubos = roubos;
    }

    public double getTocos() {
        return tocos;
    }

    public void setTocos(double tocos) {
        this.tocos = tocos;
    }

    public double getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(double turnovers) {
        this.turnovers = turnovers;
    }

    public int getOverallCalculado() {
        return overallCalculado;
    }

    public void setOverallCalculado(int overallCalculado) {
        this.overallCalculado = overallCalculado;
    }

    
}
