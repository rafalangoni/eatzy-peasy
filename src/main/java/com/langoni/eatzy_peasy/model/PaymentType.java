package com.langoni.eatzy_peasy.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "payment_type")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PaymentType {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;
}
