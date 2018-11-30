package com.fortex.backend.waybill.elements;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fortex.backend.waybill.waybillform.WaybillForm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

/**
 * ElementDate
 */

 @Getter
 @Setter
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @Entity
public class ElementDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="WAYBILLFORM_ID")
    private WaybillForm waybillFormDate;

    private Date date;
    private Boolean required;
    
}