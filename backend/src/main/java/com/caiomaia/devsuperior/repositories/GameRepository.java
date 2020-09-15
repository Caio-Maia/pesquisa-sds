package com.caiomaia.devsuperior.repositories;

import com.caiomaia.devsuperior.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
