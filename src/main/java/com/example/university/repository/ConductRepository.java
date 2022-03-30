package com.example.university.repository;

import com.example.university.models.Conduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductRepository extends JpaRepository<Conduct, Long> {
}
