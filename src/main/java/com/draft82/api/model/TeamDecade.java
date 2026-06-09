package com.draft82.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "team_decade")
@Data
public class TeamDecade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFranquia;
    private String decada;

    @OneToMany(mappedBy = "teamDecade")
    private List<PlayerDecade> jogadores;
}