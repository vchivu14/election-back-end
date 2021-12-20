package com.example.elect.entities;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "First_Name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "Last_Name", nullable = false, length = 45)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "Parties_id", referencedColumnName = "id", nullable = false)
    private Party party;

}
