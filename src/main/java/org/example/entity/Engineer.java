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
@Table(name = "engineers")
public class Engineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "engineers")
    @ToString.Exclude
    private Set<Speciality> specialities = new HashSet<>();

    @ManyToMany(mappedBy = "engineers")
    @ToString.Exclude
    private Set<Object> objects = new HashSet<>();

}
