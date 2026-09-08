package com.example.asm01.controller;

import com.example.asm01.dto.CandidateCreateDTO;
import com.example.asm01.dto.CandidateUpdateDTO;
import com.example.asm01.entity.Candidate;
import com.example.asm01.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(
            @Valid @RequestBody CandidateCreateDTO dto) {

        Candidate candidate = candidateService.createCandidate(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(candidate);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Candidate> updateCandidate(
            @PathVariable Integer id,
            @Valid @ModelAttribute CandidateUpdateDTO dto) {

        Candidate candidate = candidateService.updateCandidate(id, dto);

        return ResponseEntity.ok(candidate);
    }
}