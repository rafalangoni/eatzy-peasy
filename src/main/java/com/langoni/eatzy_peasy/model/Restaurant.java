package com.langoni.eatzy_peasy.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

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
