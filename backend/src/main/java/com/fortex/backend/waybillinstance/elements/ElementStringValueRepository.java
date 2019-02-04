
package com.fortex.backend.waybillinstance.elements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ElementStringValueRepository
 */
@Repository
public interface ElementStringValueRepository extends JpaRepository<ElementStringValue, Long>{

    ElementStringValue findElementStringValueById(Long id);
}
