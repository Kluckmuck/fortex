package com.fortex.backend.waybillinstance.elements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fortex.backend.waybill.elements.ElementString;
import com.fortex.backend.waybillinstance.waybillform.WaybillFormInstance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * ElementStringValue
 */

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class ElementStringValue  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="elements_string_value_id")
    private Long id;

    private String value;

    @JoinColumn(referencedColumnName="id")
    private Long waybillFormStringValueId;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "element_string_id", nullable = true)
    private ElementString elementString;


}
