package com.langoni.eatzy_peasy.domain.repository;

import com.langoni.eatzy_peasy.domain.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
//    List<PaymentType> listAllPaymentsType();
//    PaymentType findPaymentTypeById(Long id);
//    PaymentType addPaymentType(PaymentType paymentType);
//    void removePayment(PaymentType paymentType);
//    void removePayment(Long id);
}
