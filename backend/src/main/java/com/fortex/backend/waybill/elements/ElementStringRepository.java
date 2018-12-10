
package com.fortex.backend.waybill.elements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ElementStringRepository
 */
@Repository
public interface ElementStringRepository extends JpaRepository<ElementString, Long>{

    ElementString findElementStringById(Long id);
}