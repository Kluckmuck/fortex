package com.fortex.backend.waybillinstance.waybillform;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
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
    private Long elementId;

    @OneToMany(mappedBy="waybillFormDateValueId")
    private Set<ElementDateValue>  elementDateValue;

    @OneToMany(mappedBy="waybillFormStringValueId")
    private Set<ElementStringValue> elementStringValue;

    @OneToMany(mappedBy="waybillFormDoubleValueId")
    private Set<ElementDoubleValue> elementDoubleValue;




}
