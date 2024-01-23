package org.example.paymentapiprj.Repository;

import org.example.paymentapiprj.Entity.EstimateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimateRepository extends JpaRepository<EstimateEntity, Long> {

}
