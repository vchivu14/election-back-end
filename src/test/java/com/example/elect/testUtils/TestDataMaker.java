package com.example.elect.testUtils;

import com.example.elect.entities.Candidate;
import com.example.elect.entities.Party;
import com.example.elect.repos.CandidateRepo;
import com.example.elect.repos.PartyRepo;

import java.util.ArrayList;
import java.util.List;

public class TestDataMaker {

    public static List<Party> loadParties(PartyRepo partyRepo) {
        partyRepo.deleteAll();
        List<Party> parties = new ArrayList<>();
        Party p1 = partyRepo.save(new Party("The Social Democrats"));
        parties.add(p1);
        Party p2 = partyRepo.save(new Party("The Conservative People's Party"));
        parties.add(p2);
        Party p3 = partyRepo.save(new Party("Socialist People's Party"));
        parties.add(p3);
        Party p4 = partyRepo.save(new Party("Danish People's Party"));
        parties.add(p4);
        Party p5 = partyRepo.save(new Party("Denmark's Liberal Party"));
        parties.add(p5);
        Party p6 = partyRepo.save(new Party("The Red-Greens"));
        parties.add(p6);
        return parties;
    }

    public static List<Candidate> loadCandidatesPartyNoOne(PartyRepo partyRepo, CandidateRepo candidateRepo) {
        List<Candidate> candidates = new ArrayList<>();

        Party p1 = partyRepo.save(new Party("The Social Democrats"));

        Candidate c1 = new Candidate("Marcel", "Meijer", p1);
        candidates.add(c1);
        candidateRepo.save(c1);

        Candidate c2 = new Candidate("Michael", "Kristensen", p1);
        candidates.add(c2);
        candidateRepo.save(c2);

        Candidate c3 = new Candidate("Karina", "Knobelauch", p1);
        candidates.add(c3);
        candidateRepo.save(c3);

        Candidate c4 = new Candidate("Helle", "Hansen", p1);
        candidates.add(c4);
        candidateRepo.save(c4);

        Candidate c5 = new Candidate("Stefan", "Hafstein Wolffbrandt", p1);
        candidates.add(c5);
        candidateRepo.save(c5);

        Candidate c6 = new Candidate("Robert V.", "Rasmussen", p1);
        candidates.add(c6);
        candidateRepo.save(c6);

        Candidate c7 = new Candidate("Pia", "Ramsing", p1);
        candidates.add(c7);
        candidateRepo.save(c7);

        Candidate c8 = new Candidate("Anders", "Baun Sørensen", p1);
        candidates.add(c8);
        candidateRepo.save(c8);

        return candidates;
    }

    public static List<Candidate> loadCandidatesPartyNoTwo(PartyRepo partyRepo, CandidateRepo candidateRepo) {
        Party p = partyRepo.save(new Party("The Conservative People's Party"));

        List<Candidate> candidates = new ArrayList<>();

        List<Candidate> candidatesListOne = new ArrayList<>();
        Candidate c1 = new Candidate("Per Urban", "Olsen");
        candidatesListOne.add(c1);

        Candidate c2 = new Candidate("Peter", "Askjær");
        candidatesListOne.add(c2);

        Candidate c3 = new Candidate("Martin", "Sørensen");
        candidatesListOne.add(c3);

        p.setCandidates(candidatesListOne);
        Party pAfterFirstThree = partyRepo.save(p);

        Candidate c4 = new Candidate("Louise", "Bramstorp", p);
        Candidate c5 = new Candidate("Sigfred", "Jensen", p);
        candidatesListOne.add(c4);
        candidatesListOne.add(c5);
        pAfterFirstThree.getCandidates().add(c4);
        Party pAfter = partyRepo.save(pAfterFirstThree);

        List<Candidate> candidatesListTwo = new ArrayList<>();
        Candidate c6 = new Candidate("Jørn C.", "Nissen", pAfter);
        candidatesListTwo.add(c6);
        Candidate c7 = new Candidate("Morten Ø.", "Kristensen", pAfter);
        candidatesListTwo.add(c7);
        Candidate c8 = new Candidate("Susanne", "Andersen", pAfter);
        candidatesListTwo.add(c8);
        Candidate c9 = new Candidate("Iulian V.", "Paiu", pAfter);
        candidatesListTwo.add(c9);
        Candidate c10 = new Candidate("Per", "Hingel", pAfter);
        candidatesListTwo.add(c10);
        pAfter.getCandidates().addAll(candidatesListTwo);
        partyRepo.save(pAfter);

        candidates.addAll(candidatesListOne);
        candidates.addAll(candidatesListTwo);
        return candidates;
    }

    public static List<Candidate> loadCandidatesPartyNoThree(PartyRepo partyRepo, CandidateRepo candidateRepo) {
        Party p3 = partyRepo.save(new Party("Socialist People's Party"));

        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("Ulla", "Holm", p3));
        candidates.add(new Candidate("Kjeld", "Bønkel", p3));
        candidates.add(new Candidate("Anne Grethe", "Olsen", p3));
        candidates.add(new Candidate("Lone", "Krag", p3));
        candidates.add(new Candidate("Børge S.", "Buur", p3));

        p3.setCandidates(candidates);

        return candidates;
    }

    public static List<Candidate> loadCandidatesPartyNoFour(PartyRepo partyRepo, CandidateRepo candidateRepo) {
        Party p4 = partyRepo.save(new Party("Danish People's Party"));

        List<Candidate> candidates = new ArrayList<>();
        Candidate c1 = candidateRepo.save(new Candidate("Per", "Mortensen", p4));
        candidates.add(c1);

        return candidates;
    }

    public static List<Candidate> loadCandidatesPartyNoFive(PartyRepo partyRepo, CandidateRepo candidateRepo) {
        Party p = partyRepo.save(new Party("Denmark's Liberal Party"));

        List<Candidate> candidates = new ArrayList<>();
        Candidate c1 = new Candidate("Søren", "Wiese");
        candidates.add(c1);
        p.setCandidates(candidates);
        Party p5 = partyRepo.save(p);

        //shouldn't be saved, still is retrieved with the list
        Candidate c2 = new Candidate("Anita Elgaard", "Højholt Olesen");
        candidates.add(c2);

        Candidate c3 = new Candidate("Carsten", "Bruun");
        candidates.add(c3);
        p5.getCandidates().add(c3);
        Candidate c4 = new Candidate("Mogens", "Exner");
        candidates.add(c4);
        p5.getCandidates().add(c4);
        Candidate c5 = new Candidate("Anja", "Guldborg");
        candidates.add(c5);
        p5.getCandidates().add(c5);
        Candidate c6 = new Candidate("Klaus", "Holdorf");
        candidates.add(c6);
        p5.getCandidates().add(c6);

        partyRepo.save(p5);
        return candidates;
    }

    public static List<Candidate> loadCandidatesPartyNoSix(PartyRepo partyRepo, CandidateRepo candidateRepo) {
        Party p6 = partyRepo.save(new Party("The Red-Greens"));

        List<Candidate> candidates = new ArrayList<>();
        candidates.add(candidateRepo.save(new Candidate("Katrine", "Høegh Mc Quaid", p6)));
        Candidate c2 = candidateRepo.save(new Candidate("Jette", "M. Søgaard", p6));
        Party pAfter = partyRepo.findByName("The Red-Greens");
        // adding again to the list after candidate was saved
        pAfter.getCandidates().add(c2);
        List<Candidate> candidatesList = new ArrayList<>();
        candidates.add(new Candidate("Søren", "Caspersen", p6));
        candidates.add(new Candidate("Pia", "Birkmand", p6));
        candidatesList.add(candidateRepo.save(new Candidate("Søren", "Caspersen", p6)));
        candidatesList.add(candidateRepo.save(new Candidate("Pia", "Birkmand", p6)));
        Party pAfterTwo = partyRepo.findByName("The Red-Greens");
        pAfterTwo.getCandidates().addAll(candidatesList);
        // adding once again the list
        Party pAfterThree = partyRepo.findByName("The Red-Greens");
        pAfterThree.getCandidates().addAll(candidatesList);
        return candidates;
    }

}