package com.fortex.backend.waybillinstance.elements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ElementDoubleValueRepository
 */
@Repository
public interface ElementDoubleValueRepository extends JpaRepository<ElementDoubleValue, Long>{
    ElementDoubleValue findElementDoubleValueById(Long id);

}
