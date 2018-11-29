package com.fortex.backend.waybill.elements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ElementDateRepository
 */
@Repository
public interface ElementDateRepository  extends JpaRepository<ElementDate, Long>{

    ElementDate findElementDateById(Long id);
    
}