package com.example.elect.services;

import com.example.elect.dtos.PartyDTO;
import com.example.elect.entities.Party;
import com.example.elect.repos.PartyRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartyServicesImp implements PartyService {
    private PartyRepo partyRepo;
    private CandidateService candidateService;

    public PartyServicesImp(PartyRepo partyRepo, CandidateService candidateService) {
        this.partyRepo = partyRepo;
        this.candidateService = candidateService;
    }

    @Override
    public List<PartyDTO> getAllParties() {
        List<Party> parties = partyRepo.findAll();
        List<PartyDTO> partyDTOS = new ArrayList<>();
        for (Party p: parties) {
            PartyDTO partyDTO = new PartyDTO();
            partyDTO.setId(p.getId());
            partyDTO.setName(p.getName());
            partyDTO.setCandidateDTOList(candidateService.getAllCandidatesForParty(p));
            partyDTOS.add(partyDTO);
        }
        return partyDTOS;
    }

    @Override
    public PartyDTO getPartyById(Integer id) {
        Party party = partyRepo.getById(id);
        PartyDTO partyDTO = new PartyDTO();
        partyDTO.setId(party.getId());
        partyDTO.setName(party.getName());
        partyDTO.setCandidateDTOList(candidateService.getAllCandidatesForParty(party));
        return partyDTO;
    }
}
