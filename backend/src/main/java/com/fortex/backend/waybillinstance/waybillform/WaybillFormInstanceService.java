package com.fortex.backend.waybillinstance.waybillform;

import com.fortex.backend.exceptions.ResourceNotFoundException;
import com.fortex.backend.waybill.waybillform.WaybillForm;
import com.fortex.backend.waybill.waybillform.WaybillFormRepository;
import com.fortex.backend.waybillinstance.elements.ElementDateValueRepository;
import com.fortex.backend.waybillinstance.elements.ElementDoubleValueRepository;
import com.fortex.backend.waybillinstance.elements.ElementStringValue;
import com.fortex.backend.waybillinstance.elements.ElementStringValueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaybillFormInstanceService {

    @Autowired
    WaybillFormInstanceRepository waybillFormInstanceRepository;

    @Autowired
    ElementDateValueRepository elementDateRepository;

    @Autowired
    ElementDoubleValueRepository elementDoubleRepository;

    @Autowired
    ElementStringValueRepository elementStringRepository;

    @Autowired
    WaybillFormRepository waybillFormRepository;

    public WaybillFormInstance createNewWaybill(Long id, WaybillFormInstance waybillFormInstance) {
        /**
         * Add each element and sets waybillform id. TODO: solve ManyToOne annotation
         */
        waybillFormRepository.findById(id).map(waybillForm -> {
            waybillFormInstance.setFormId(waybillForm.getId());
            waybillFormInstanceRepository.save(waybillFormInstance); // Saving

            if (waybillForm.getElementString() != null) {
                waybillForm.getElementString().forEach(elementString -> {
                    waybillFormInstance.getElementStringValue().forEach(elementStringValue -> {
                        //cannot rely on id because its auto generated.
                        if(elementString.getId().equals(elementStringValue.getElementString().getId())){
                            elementStringValue.setElementString(elementString);
                            elementStringValue.setWaybillFormStringValueId(waybillFormInstance.getId());
                            elementStringRepository.save(elementStringValue);
                        }
                    });
                });
            }

            if (waybillFormInstance.getElementDateValue() != null) {
                waybillFormInstance.getElementDateValue().forEach(elementDate -> {
                    elementDate.setWaybillFormDateValueId(waybillFormInstance.getId());
                    elementDateRepository.save(elementDate);
                });
            }

            if (waybillFormInstance.getElementDoubleValue() != null) {
                waybillFormInstance.getElementDoubleValue().forEach(elementDouble -> {
                    elementDouble.setWaybillFormDoubleValueId(waybillFormInstance.getId());
                    elementDoubleRepository.save(elementDouble);
                });
            }
            return waybillFormInstance;
        });
        return waybillFormInstance;
    }

    public WaybillFormInstance findWaybillById(Long id) {
        WaybillFormInstance waybillFormInstance = waybillFormInstanceRepository.findWaybillById(id);
        System.out.println(waybillFormInstance.toString());
        return waybillFormInstance;
    }

}
