package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "specialities")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ToString.Exclude
    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "engineers_specialities",
            joinColumns = @JoinColumn(name = "speciality_id"),
            inverseJoinColumns = @JoinColumn(name = "engineer_id")
    )
    private Set<Engineer> engineers = new HashSet<>();
}
