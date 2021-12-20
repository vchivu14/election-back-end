package com.example.elect.configuration;

import com.example.elect.entities.Candidate;
import com.example.elect.entities.Party;
import com.example.elect.repos.CandidateRepo;
import com.example.elect.repos.PartyRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!test")
public class DataLoader {
    private CandidateRepo candidateRepo;
    private PartyRepo partyRepo;

    public DataLoader(CandidateRepo candidateRepo, PartyRepo partyRepo) {
        this.candidateRepo = candidateRepo;
        this.partyRepo = partyRepo;
        if (partyRepo.count() == 0) {
            loadData();
        }
    }

    void loadData() {
        Party p1 = partyRepo.save(new Party(1,"The Social Democrats"));
        candidateRepo.save(new Candidate("Marcel", "Meijer", p1));
        candidateRepo.save(new Candidate("Michael", "Kristensen", p1));
        candidateRepo.save(new Candidate("Karina", "Knobelauch", p1));
        candidateRepo.save(new Candidate("Helle", "Hansen", p1));
        candidateRepo.save(new Candidate("Stefan", "Hafstein Wolffbrandt", p1));
        candidateRepo.save(new Candidate("Robert V.", "Rasmussen", p1));
        candidateRepo.save(new Candidate("Pia", "Ramsing", p1));
        candidateRepo.save(new Candidate("Anders", "Baun Sørensen", p1));

        Party p2 = partyRepo.save(new Party(2, "The Conservative People's Party"));
        candidateRepo.save(new Candidate("Per Urban", "Olsen", p2));
        candidateRepo.save(new Candidate("Peter", "Askjær", p2));
        candidateRepo.save(new Candidate("Martin", "Sørensen"));
        candidateRepo.save(new Candidate("Louise", "Bramstorp", p2));
        candidateRepo.save(new Candidate("Sigfred", "Jensen", p2));
        candidateRepo.save(new Candidate("Jørn C.", "Nissen", p2));
        candidateRepo.save(new Candidate("Morten Ø.", "Kristensen", p2));
        candidateRepo.save(new Candidate("Susanne", "Andersen", p2));
        candidateRepo.save(new Candidate("Iulian V.", "Paiu", p2));
        candidateRepo.save(new Candidate("Per", "Hingel", p2));

        Party p3 = partyRepo.save(new Party(3, "Socialist People's Party"));
        candidateRepo.save(new Candidate("Ulla", "Holm", p3));
        candidateRepo.save(new Candidate("Kjeld", "Bønkel", p3));
        candidateRepo.save(new Candidate("Anne Grethe", "Olsen", p3));
        candidateRepo.save(new Candidate("Lone", "Krag", p3));
        candidateRepo.save(new Candidate("Børge S.", "Buur", p3));

        Party p4 = partyRepo.save(new Party(4, "Danish People's Party"));
        candidateRepo.save(new Candidate("Per", "Mortensen", p4));

        Party p5 = partyRepo.save(new Party(5, "Denmark's Liberal Party"));
        candidateRepo.save(new Candidate("Søren", "Wiese", p5));
        candidateRepo.save(new Candidate("Anita Elgaard", "Højholt Olesen", p5));
        candidateRepo.save(new Candidate("Carsten", "Bruun", p5));
        candidateRepo.save(new Candidate("Mogens", "Exner", p5));
        candidateRepo.save(new Candidate("Anja", "Guldborg", p5));
        candidateRepo.save(new Candidate("Klaus", "Holdorf", p5));

        Party p6 = partyRepo.save(new Party(6,"The Red-Greens"));
        candidateRepo.save(new Candidate("Katrine", "Høegh Mc Quaid", p6));
        candidateRepo.save(new Candidate("Jette", "M. Søgaard", p6));
        candidateRepo.save(new Candidate("Søren", "Caspersen", p6));
        candidateRepo.save(new Candidate("Pia", "Birkmand", p6));

        partyRepo.save(new Party(7,"The Others"));
    }

}
