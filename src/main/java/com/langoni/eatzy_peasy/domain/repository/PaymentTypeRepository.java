package com.langoni.eatzy_peasy.domain.repository;

import com.langoni.eatzy_peasy.domain.model.PaymentType;

import java.util.List;

public interface PaymentTypeRepository {
    List<PaymentType> listAllPaymentsType();
    PaymentType findPaymentTypeById(Long id);
    PaymentType addPaymentType(PaymentType paymentType);
    void removePayment(PaymentType paymentType);
    void removePayment(Long id);
}
