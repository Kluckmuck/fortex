package com.fortex.backend.waybill.elements;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.*;

/**
 * ElementDouble
 */

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ElementDouble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String valueName;
    private Boolean required;
    

    @JoinColumn(referencedColumnName="id")
    private Long waybillFormDoubleId;

}