package com.example.elect.repos;

import com.example.elect.entities.Party;
import com.example.elect.testUtils.TestDataMaker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PartyRepoTest {

    @Autowired
    PartyRepo partyRepo;

    @BeforeEach
    void loadData() {
        TestDataMaker.loadParties(partyRepo);
    }

    @AfterEach
    void cleanDB() {
        partyRepo.deleteAll();
    }

    @Test
    void findAll() {
        assertEquals(6, partyRepo.count());
    }

    @Test
    void findPartyByName() {
        Party party = partyRepo.findByName("The Social Democrats");
        assertNotNull(party);
    }
}