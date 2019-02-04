package com.fortex.backend.waybill.elements;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fortex.backend.waybillinstance.elements.ElementStringValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ElementString
 */

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ElementString {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Boolean required;

    @JoinColumn(referencedColumnName="id")
    private Long waybillFormStringId;

}