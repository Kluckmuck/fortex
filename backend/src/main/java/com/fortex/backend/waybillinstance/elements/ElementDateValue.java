package com.fortex.backend.waybillinstance.elements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fortex.backend.waybill.elements.ElementDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

/**
 * ElementDateValue
 */

 @Getter
 @Setter
 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @Entity
public class ElementDateValue {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn( referencedColumnName = "id")
    private Long waybillFormDateValueId;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date value;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "element_date_id", nullable = true)
    private ElementDate elementDate;
}
