package org.sample.park.repository;

import org.sample.park.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TestRepository extends JpaRepository<Test, UUID> {
    boolean existsByDescription(String description);
}
