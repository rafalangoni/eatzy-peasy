package com.langoni.eatzy_peasy.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Lazy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @JsonIgnoreProperties("hibernateLazyInitializer")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kitchen_id", nullable = false)
    private Kitchen kitchen;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "restaurant_payment_type",
        joinColumns = @JoinColumn(name = "restaurant_id"),
        inverseJoinColumns = @JoinColumn(name = "payment_type_id"))
    private List<PaymentType> paymentTypes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private List<Product> products = new ArrayList<>();

    @JsonIgnore
    @Embedded
    private Address address;

    @CreationTimestamp
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

}
