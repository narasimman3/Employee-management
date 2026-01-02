package com.epm.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epm.Model.Increment;

public interface IncrementRepository extends JpaRepository<Increment, Long>{
    Optional<Increment>findByReason(String reason);
    
}
