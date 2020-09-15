package com.caiomaia.devsuperior.controllers;

import com.caiomaia.devsuperior.dto.RecordDTO;
import com.caiomaia.devsuperior.dto.RecordInsertDTO;
import com.caiomaia.devsuperior.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping(value = "/records")
public class RecordController {

    @Autowired
    private RecordService service;

    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) {
        RecordDTO newDTO = service.insert(dto);
        return ResponseEntity.ok().body(newDTO);
    }

    @GetMapping
    public ResponseEntity<Page<RecordDTO>> findAll(
            @RequestParam(value = "min", defaultValue = "") String min,
            @RequestParam(value = "max", defaultValue = "") String max,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction)
    {
        Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
        Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

        if(linesPerPage == 0) {
            linesPerPage = Integer.MAX_VALUE;
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<RecordDTO> list = service.findByMoments(minDate, maxDate, pageRequest);
        return ResponseEntity.ok().body(list);
    }
}
