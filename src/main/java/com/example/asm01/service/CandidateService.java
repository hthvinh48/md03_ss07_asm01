package com.example.asm01.service;

import com.example.asm01.dto.CandidateCreateDTO;
import com.example.asm01.entity.Candidate;

public interface CandidateService {

    Candidate createCandidate(CandidateCreateDTO dto);
}