package org.sample.park.repository;

import org.sample.park.model.ValeurCapteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ValeurCapteurRepository extends JpaRepository<ValeurCapteur, UUID> {
}
