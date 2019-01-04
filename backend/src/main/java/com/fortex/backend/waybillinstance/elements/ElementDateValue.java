package com.fortex.backend.waybillinstance.elements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

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

    private Date value;
}
