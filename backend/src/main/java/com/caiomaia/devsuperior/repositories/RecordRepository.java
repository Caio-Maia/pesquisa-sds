package com.caiomaia.devsuperior.repositories;

import com.caiomaia.devsuperior.entities.Record;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

    @Query("SELECT obj FROM Record obj WHERE"
            + "(coalesce(:min, null) IS NULL OR obj.moment >= :min) AND "
            + "(coalesce(:max, null) IS NULL OR obj.moment <= :max)")
    Page<Record> findByMoments(Instant min, Instant max, Pageable pageable);
}
