package com.example.elect.repos;

import com.example.elect.entities.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepo extends JpaRepository<Party, Integer> {
    Party findByName(String name);
}
