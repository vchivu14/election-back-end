package com.example.elect.rest;

import com.example.elect.entities.Party;
import com.example.elect.repos.PartyRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/parties")
public class RESTParty {
    private PartyRepo partyRepo;

    public RESTParty(PartyRepo partyRepo) {
        this.partyRepo = partyRepo;
    }

    @GetMapping
    public ResponseEntity<List<Party>> getParties() {
        List<Party> parties = partyRepo.findAll();
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }
}
