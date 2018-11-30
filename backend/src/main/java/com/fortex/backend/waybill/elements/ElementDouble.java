package com.fortex.backend.waybill.elements;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fortex.backend.waybill.waybillform.WaybillForm;

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
    private Double value;
    private Boolean required;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="WAYBILLFORM_ID")
    private WaybillForm waybillFormDouble;

}