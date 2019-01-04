package com.fortex.backend.waybillinstance.elements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ElementDateValueRepository
 */
@Repository
public interface ElementDateValueRepository  extends JpaRepository<ElementDateValue, Long>{

    ElementDateValue findElementDateValueById(Long id);

}
