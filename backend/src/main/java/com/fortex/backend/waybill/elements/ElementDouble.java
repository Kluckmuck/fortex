package com.fortex.backend.waybill.elements;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

/**
 * ElementDouble
 */

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ElementDouble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
    private Boolean required;

}