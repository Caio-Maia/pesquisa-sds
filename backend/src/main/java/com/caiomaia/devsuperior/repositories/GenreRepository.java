package com.caiomaia.devsuperior.repositories;

import com.caiomaia.devsuperior.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
