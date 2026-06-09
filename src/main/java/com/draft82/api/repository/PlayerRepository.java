package com.draft82.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.draft82.api.model.PlayerDecade;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerDecade, Long> {
    // O JpaRepository já nos dá métodos como:
    // save(), findAll(), findById(), deleteById(), etc.
}