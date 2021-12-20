package com.example.elect.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "parties", schema = "election")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "Name", nullable = false, length = 45)
    private String name;

    @OneToMany(mappedBy = "party")
    private List<Candidate> candidates;

}
