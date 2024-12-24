package com.langoni.eatzy_peasy.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "city")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
