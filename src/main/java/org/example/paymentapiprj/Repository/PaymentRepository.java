package org.example.paymentapiprj.Repository;

import org.example.paymentapiprj.Entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
