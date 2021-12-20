package com.example.elect.services;

import com.example.elect.dtos.CandidateDTO;
import com.example.elect.dtos.InputCandidateDTO;

import java.util.List;

public interface CandidateService {
    List<CandidateDTO> getAllCandidates(Integer partyId);

    CandidateDTO getCandidateById(Integer id);
    CandidateDTO addCandidate(InputCandidateDTO inputCandidateDTO);
    CandidateDTO updateCandidate(CandidateDTO candidateDTO);
    void removeCandidate(Integer candidateId);
}
