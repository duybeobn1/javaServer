package org.sample.park.repository;

import org.sample.park.model.ValeurCapteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ValeurCapteurRepository extends JpaRepository<ValeurCapteur, UUID> {

    @Query(value = "SELECT * FROM valeur_capteur ORDER BY temps DESC LIMIT 10", nativeQuery = true)
    List<ValeurCapteur> findRecentResults();
}
