package com.example.elect.repos;

import com.example.elect.entities.Candidate;
import com.example.elect.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepo extends JpaRepository<Candidate, Integer> {
    List<Candidate> findAllByParty(Party party);
}
