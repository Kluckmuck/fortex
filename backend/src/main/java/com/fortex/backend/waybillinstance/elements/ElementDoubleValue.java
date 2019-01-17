package com.fortex.backend.waybillinstance.elements;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fortex.backend.waybill.elements.ElementDouble;
import com.fortex.backend.waybillinstance.waybillform.WaybillFormInstance;

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

    @JoinColumn(referencedColumnName="id")
    private Long waybillFormDoubleValueId;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "element_double_id", nullable = true)
    private ElementDouble elementDouble;
}
