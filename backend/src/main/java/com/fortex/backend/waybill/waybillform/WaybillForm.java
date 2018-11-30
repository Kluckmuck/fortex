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

    @OneToMany(mappedBy="waybillFormDate")
    private Set<ElementDate>  elementDate;

    @OneToMany(mappedBy="waybillFormString")
    private Set<ElementString> elementString;
    
    @OneToMany(mappedBy="waybillFormDouble")
    private Set<ElementDouble> elementDouble;

    


}
