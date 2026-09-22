package com.draft82.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.draft82.api.model.DraftPick;

@Repository
public interface DraftPickRepository extends JpaRepository<DraftPick, Long> {
}