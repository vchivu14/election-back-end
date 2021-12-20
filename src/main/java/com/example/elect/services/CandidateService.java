package com.example.elect.services;

import com.example.elect.dtos.CandidateDTO;
import com.example.elect.dtos.InputCandidateDTO;
import com.example.elect.entities.Party;

import java.util.List;

public interface CandidateService {
    List<CandidateDTO> getAllCandidates(Integer partyId);
    List<CandidateDTO> getAllCandidatesForParty(Party party);

    CandidateDTO getCandidateById(Integer id);
    CandidateDTO addCandidate(InputCandidateDTO inputCandidateDTO);
    CandidateDTO updateCandidate(CandidateDTO candidateDTO);
    void removeCandidate(Integer candidateId);
}
