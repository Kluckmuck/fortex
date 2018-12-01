package com.fortex.backend.waybill.elements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ElementDoubleRepository
 */
@Repository
public interface ElementDoubleRepository extends JpaRepository<ElementDouble, Long>{
    ElementDouble findElementDoubleById(Long id);
    
}