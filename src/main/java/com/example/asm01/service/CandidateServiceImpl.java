package com.example.asm01.service;

import com.example.asm01.dto.CandidateCreateDTO;
import com.example.asm01.dto.CandidateUpdateDTO;
import com.example.asm01.entity.Candidate;
import com.example.asm01.repository.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Candidate createCandidate(CandidateCreateDTO dto) {
        Candidate candidate = new Candidate(
                dto.getFullName(),
                dto.getEmail(),
                dto.getAge(),
                dto.getYearsOfExperience()
        );

        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Integer id, CandidateUpdateDTO dto) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        candidate.setAddress(dto.getAddress());
        candidate.setBio(dto.getBio());

        return candidateRepository.save(candidate);
    }
}