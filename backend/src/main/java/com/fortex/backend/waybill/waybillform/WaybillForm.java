package com.fortex.backend.waybill.waybillform;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String name;
    private Date date;
    private Long orgId;

    @ElementCollection
    @CollectionTable(name = "waybill_element_date", joinColumns = @JoinColumn(name = "elementdate_id"))
    private Set<ElementDate>  elementDate;

    @ElementCollection
    @CollectionTable(name = "waybill_element_string", joinColumns = @JoinColumn(name = "elementstring_id"))
    private Set<ElementString> elementString;
    
    @ElementCollection
    @CollectionTable(name = "waybill_element_double", joinColumns = @JoinColumn(name = "elementdouble_id"))
    private Set<ElementDouble> elementDouble;

    


}
