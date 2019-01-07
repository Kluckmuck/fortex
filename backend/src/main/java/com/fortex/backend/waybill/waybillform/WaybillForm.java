package com.fortex.backend.waybill.waybillform;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fortex.backend.organization.Organization;
import com.fortex.backend.waybill.elements.ElementDate;
import com.fortex.backend.waybill.elements.ElementDouble;
import com.fortex.backend.waybill.elements.ElementString;

@Getter
@Setter
@Data
@ToString
@Entity
public class WaybillForm {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date date;

    @OneToMany(mappedBy="waybillFormDateId")
    private Set<ElementDate>  elementDate = new HashSet<>();

    @OneToMany(mappedBy="waybillFormStringId")
    private Set<ElementString> elementString;
    
    @OneToMany(mappedBy="waybillFormDoubleId")
    private Set<ElementDouble> elementDouble;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization_id", nullable = true)
    private Organization organization;


}
