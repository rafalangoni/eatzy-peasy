package com.langoni.eatzy_peasy.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "sub_total")
    private BigDecimal subTotal;

    @Column(name = "delivery_fee")
    private BigDecimal deliveryFee;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "confirmation_date")
    private LocalDate confirmationDate;

    @Column(name = "order_cancel_date")
    private LocalDate orderCancelDate;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

}
