package com.example.elect.rest;

import com.example.elect.dtos.CandidateDTO;
import com.example.elect.services.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/candidates")
public class RESTCandidates {
    private CandidateService candidateService;

    public RESTCandidates(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public ResponseEntity<List<CandidateDTO>> getCandidates(@RequestParam(required = false) Integer partyId) {
        List<CandidateDTO> candidateDTOS = candidateService.getAllCandidates(partyId);
        return new ResponseEntity<>(candidateDTOS, HttpStatus.OK);
    }

}
