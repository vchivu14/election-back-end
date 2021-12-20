package com.example.elect.services;

import com.example.elect.dtos.CandidateDTO;
import com.example.elect.dtos.InputCandidateDTO;
import com.example.elect.entities.Candidate;
import com.example.elect.entities.Party;
import com.example.elect.exceptions.ResourceNotFoundException;
import com.example.elect.repos.CandidateRepo;
import com.example.elect.repos.PartyRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateServiceImp implements CandidateService {
    private CandidateRepo candidateRepo;
    private PartyRepo partyRepo;

    public CandidateServiceImp(CandidateRepo candidateRepo, PartyRepo partyRepo) {
        this.candidateRepo = candidateRepo;
        this.partyRepo = partyRepo;
    }

    private String errorMessageOne(long id){
        return "No candidate found with id = " + id;
    }
    private String errorMessageTwo() {
        return "No candidates found";
    }
    private String errorMessageThree(String party) {
        return "No candidates found for this party "+ party;
    }

    private Candidate findCandidate(Integer id) {
        return candidateRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(errorMessageOne(id)));
    }

    @Override
    public CandidateDTO getCandidateById(Integer id) {
        Candidate candidate = findCandidate(id);
        CandidateDTO candidateDTO = new CandidateDTO();
        candidateDTO.setId(candidate.getId());
        candidateDTO.setFirstName(candidate.getFirstName());
        candidateDTO.setLastName(candidate.getLastName());
        return candidateDTO;
    }

    private List<CandidateDTO> getCandidateDTOs(List<Candidate> candidates) {
        List<CandidateDTO> candidateDTOs = new ArrayList<>();
        for (Candidate c: candidates) {
            candidateDTOs.add(new CandidateDTO(c));
        }
        return candidateDTOs;
    }

    @Override
    public List<CandidateDTO> getAllCandidates(Integer partyId) {
        if (partyId == null) {
            if (candidateRepo.count() == 0) {
                throw new ResourceNotFoundException(errorMessageTwo());
            } else {
                List<Candidate> candidates = candidateRepo.findAll();
                return getCandidateDTOs(candidates);
            }
        } else {
            Party party = partyRepo.getById(partyId);
            if (candidateRepo.findAllByParty(party).size() == 0) {
                throw new ResourceNotFoundException(errorMessageThree(party.getName()));
            } else {
                List<Candidate> candidates = candidateRepo.findAllByParty(party);
                return getCandidateDTOs(candidates);
            }
        }
    }

    @Override
    public CandidateDTO addCandidate(InputCandidateDTO inputCandidateDTO) {
        Candidate candidate = new Candidate();
        candidate.setFirstName(inputCandidateDTO.getFirstName());
        candidate.setLastName(inputCandidateDTO.getLastName());
        Party party = partyRepo.getById(inputCandidateDTO.getPartyId());
        candidate.setParty(party);
        Candidate candidateSaved = candidateRepo.save(candidate);
        return new CandidateDTO(candidateSaved);
    }

    @Override
    public CandidateDTO updateCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = findCandidate(candidateDTO.getId());
        String firstName = candidateDTO.getFirstName();
        String lastName = candidateDTO.getLastName();
        if (!firstName.equals("")) {
            candidate.setFirstName(firstName);
        }
        if (!lastName.equals("")) {
            candidate.setLastName(lastName);
        }
        Candidate candidateUpdated = candidateRepo.save(candidate);
        return new CandidateDTO(candidateUpdated);
    }

    @Override
    public void removeCandidate(Integer candidateId) {
        Candidate candidate = findCandidate(candidateId);
        candidateRepo.delete(candidate);
    }
}
