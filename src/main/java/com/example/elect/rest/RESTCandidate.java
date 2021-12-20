package com.example.elect.rest;

import com.example.elect.dtos.CandidateDTO;
import com.example.elect.dtos.InputCandidateDTO;
import com.example.elect.services.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/candidate")
public class RESTCandidate {
    private CandidateService candidateService;

    public RESTCandidate(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public ResponseEntity<CandidateDTO> getCandidate(@RequestParam Integer id) {
        CandidateDTO candidateDTO = candidateService.getCandidateById(id);
        return new ResponseEntity<>(candidateDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CandidateDTO> addCandidate(@RequestBody InputCandidateDTO inputCandidateDTO) {
        CandidateDTO candidateDTO = candidateService.addCandidate(inputCandidateDTO);
        return new ResponseEntity<>(candidateDTO, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CandidateDTO> updateCandidate(@RequestBody CandidateDTO candidateDTO) {
        CandidateDTO candidateDTOUpdated = candidateService.updateCandidate(candidateDTO);
        return new ResponseEntity<>(candidateDTOUpdated, HttpStatus.OK);
    }

    @DeleteMapping
    public void removeCandidate(@RequestParam Integer id) {
        candidateService.removeCandidate(id);
    }


}
