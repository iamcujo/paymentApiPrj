package org.example.paymentapiprj.Repository;

import org.example.paymentapiprj.Entity.BalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BalanceRepository extends JpaRepository<BalanceEntity, Long> {

    Optional<BalanceEntity> findByUserId(String userId);

}
