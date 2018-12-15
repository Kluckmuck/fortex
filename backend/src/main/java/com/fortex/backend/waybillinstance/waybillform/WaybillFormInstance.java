package com.fortex.backend.waybillinstance.waybillform;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fortex.backend.waybillinstance.elements.ElementDateValue;
import com.fortex.backend.waybillinstance.elements.ElementDoubleValue;
import com.fortex.backend.waybillinstance.elements.ElementStringValue;

@Getter
@Setter
@Data
@ToString
@Entity
public class WaybillFormInstance {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private Long formId;
    private Date date;

    @OneToMany(mappedBy="waybillFormDateValueId")
    private Set<ElementDateValue>  elementDate;

    @OneToMany(mappedBy="waybillFormStringValueId")
    private Set<ElementStringValue> elementString;

    @OneToMany(mappedBy="waybillFormDoubleValueId")
    private Set<ElementDoubleValue> elementDouble;




}
