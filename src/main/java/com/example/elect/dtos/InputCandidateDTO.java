package com.example.elect.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class InputCandidateDTO {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Integer partyId;
}
