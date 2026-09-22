package com.draft82.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.draft82.api.model.GameSession;

@Repository
public interface GameSessionRepository extends JpaRepository<GameSession, UUID> {
    //  UUID, porque o ID da GameSession não é long
}