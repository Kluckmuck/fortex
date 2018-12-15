package com.fortex.backend.waybillinstance.elements;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fortex.backend.waybillinstance.waybillform.WaybillForm;

import lombok.*;

/**
 * ElementDoubleValue
 */

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ElementDoubleValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;
    private Boolean required;


    @JoinColumn(referencedColumnName="id")
    private Long waybillFormDoubleId;

}
