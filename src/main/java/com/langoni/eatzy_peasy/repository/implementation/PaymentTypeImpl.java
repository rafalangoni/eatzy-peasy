package com.langoni.eatzy_peasy.repository.implementation;

import com.langoni.eatzy_peasy.model.PaymentType;
import com.langoni.eatzy_peasy.repository.PaymentTypeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PaymentTypeImpl implements PaymentTypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PaymentType> listAllPaymentsType() {
        TypedQuery<PaymentType> query = entityManager.createQuery("select p from PaymentType p", PaymentType.class);
        return query.getResultList();
    }

    @Override
    public PaymentType findPaymentTypeById(Long id) {
        return entityManager.find(PaymentType.class, id);
    }

    @Override
    @Transactional
    public PaymentType addPaymentType(PaymentType paymentType) {
        entityManager.persist(paymentType);
        return paymentType;
    }

    @Override
    @Transactional
    public void removePayment(PaymentType paymentType) {
        entityManager.remove(findPaymentTypeById(paymentType.getId()));
    }

    @Override
    @Transactional
    public void removePayment(Long id) {
        entityManager.remove(findPaymentTypeById(id));
    }
}
