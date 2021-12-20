package com.example.elect.entities;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "candidates", schema = "f58jmr16udtjclm6")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "First_Name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "Last_Name", nullable = false, length = 45)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Parties_id", referencedColumnName = "id")
    private Party party;

    public Candidate(String firstName, String lastName, Party party) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.party = party;
    }

    public Candidate(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
