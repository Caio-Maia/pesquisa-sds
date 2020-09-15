package com.caiomaia.devsuperior.controllers;

import com.caiomaia.devsuperior.dto.RecordDTO;
import com.caiomaia.devsuperior.dto.RecordInsertDTO;
import com.caiomaia.devsuperior.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
