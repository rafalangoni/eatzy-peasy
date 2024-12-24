package com.langoni.eatzy_peasy.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal deliveryFee;

//    private Boolean isOpen;
//    private Boolean isActive;
//    private LocalDate registerDate;
//    private LocalDate updateDate;

    @ManyToOne
    @JoinColumn(name = "kitchen_id")
    private Kitchen kitchen;

}
