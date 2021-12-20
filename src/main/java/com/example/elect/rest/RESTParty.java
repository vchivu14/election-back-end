package com.example.elect.rest;

import com.example.elect.dtos.PartyDTO;
import com.example.elect.entities.Party;
import com.example.elect.repos.PartyRepo;
import com.example.elect.services.PartyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/parties")
public class RESTParty {
    private PartyService partyService;

    public RESTParty(PartyService partyService) {
        this.partyService = partyService;
    }

    @GetMapping
    public ResponseEntity<List<PartyDTO>> getParties() {
        List<PartyDTO> parties = partyService.getAllParties();
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }
}
