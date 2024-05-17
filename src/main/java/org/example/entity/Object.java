package org.example.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "objects")
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ToString.Exclude
    @Builder.Default
    @ManyToMany
    @JoinTable(
            name = "engineers_objects",
            joinColumns = @JoinColumn(name = "object_id"),
            inverseJoinColumns = @JoinColumn(name = "engineer_id")
    )
    private Set<Engineer> engineers = new HashSet<>();
}
