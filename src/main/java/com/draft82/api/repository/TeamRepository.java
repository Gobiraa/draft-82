package com.draft82.api.repository;

import com.draft82.api.model.TeamDecade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<TeamDecade, Long> {
}
