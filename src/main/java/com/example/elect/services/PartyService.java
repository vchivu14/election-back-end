package com.example.elect.services;

import com.example.elect.dtos.PartyDTO;

import java.util.List;

public interface PartyService {
    List<PartyDTO> getAllParties();
    PartyDTO getPartyById(Integer id);
}
