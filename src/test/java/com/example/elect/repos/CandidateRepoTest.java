package com.example.elect.repos;

import com.example.elect.entities.Candidate;
import com.example.elect.testUtils.TestDataMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class CandidateRepoTest {

    @Autowired
    PartyRepo partyRepo;
    @Autowired
    CandidateRepo candidateRepo;

    @BeforeEach
    void cleanDB() {
        candidateRepo.deleteAll();
        partyRepo.deleteAll();
    }

    @Test
    // saving candidates with their relationship defined (feed a party object to their constructor) should allow
    // bi-directional retrieval of data
    void testCandidatesPartyNoOne() {
        List<Candidate> candidateList = TestDataMaker.loadCandidatesPartyNoOne(partyRepo, candidateRepo);
        assertEquals(8, candidateList.size());
        assertEquals(8, candidateRepo.count());
        assertEquals(8, partyRepo.findByName("The Social Democrats").getCandidates().size());
    }

    @Test
        // putting newly created candidates into a list without defining their relationship to a party,
        // list that would be saved as a property of a party created
        // shouldn't save anything in any of the tables regarding these newly created candidates

        // adding candidates as a property to a party entity without saving them first shouldn't save anything
        // even though relationship is defined
    void testCandidatesPartyNoTwo() {
        List<Candidate> candidateList = TestDataMaker.loadCandidatesPartyNoTwo(partyRepo, candidateRepo);
        assertEquals(10, candidateList.size());
        assertEquals(0, candidateRepo.count());
        assertEquals(0, partyRepo.findByName("The Conservative People's Party").getCandidates().size());
    }

    @Test
        // same thing as previous test
    void testCandidatesPartyNoThree() {
        List<Candidate> candidateList = TestDataMaker.loadCandidatesPartyNoThree(partyRepo, candidateRepo);
        assertEquals(5, candidateList.size());
        assertEquals(0, candidateRepo.count());
        assertEquals(0, partyRepo.findByName("Socialist People's Party").getCandidates().size());
    }

    @Test
        // same thing as test 1
    void testCandidatesPartyNoFour() {
        List<Candidate> candidateList = TestDataMaker.loadCandidatesPartyNoFour(partyRepo, candidateRepo);
        assertEquals(1, candidateList.size());
        assertEquals(1, candidateRepo.count());
        assertEquals(1, partyRepo.findByName("Danish People's Party").getCandidates().size());
    }

    @Test
        // same thing as test 3
    void testCandidatesPartyNoFive() {
        List<Candidate> candidateList = TestDataMaker.loadCandidatesPartyNoFive(partyRepo, candidateRepo);
        assertEquals(6, candidateList.size());
        assertEquals(0, candidateRepo.count());
        assertEquals(0, partyRepo.findByName("Denmark's Liberal Party").getCandidates().size());
    }

    @Test
        //shouldn't be allowed addition of candidates with same name;
    void testCandidatesPartyNoSix() {
        List<Candidate> candidateList = TestDataMaker.loadCandidatesPartyNoSix(partyRepo, candidateRepo);
        assertEquals(3, candidateList.size());
        assertEquals(4, candidateRepo.count());
        assertEquals(4, partyRepo.findByName("The Red-Greens").getCandidates().size());
    }

}