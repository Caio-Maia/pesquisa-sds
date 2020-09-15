package com.caiomaia.devsuperior.services;

import com.caiomaia.devsuperior.dto.RecordDTO;
import com.caiomaia.devsuperior.dto.RecordInsertDTO;
import com.caiomaia.devsuperior.entities.Game;
import com.caiomaia.devsuperior.entities.Record;
import com.caiomaia.devsuperior.repositories.GameRepository;
import com.caiomaia.devsuperior.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;


@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public RecordDTO insert(RecordInsertDTO dto) {
        Record entity = new Record();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());

        Game game = gameRepository.getOne(dto.getGameId());
        entity.setGame(game);

        entity = recordRepository.save(entity);
        return new RecordDTO(entity);
    }
}
