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
                        // Compare incoming id and id from database.
                        if(elementString.getId().equals(elementStringValue.getElementString().getId())){
                            elementStringValue.setElementString(elementString);
                            elementStringValue.setWaybillFormStringValueId(waybillFormInstance.getId());
                            elementStringRepository.save(elementStringValue);
                        }
                    });
                });
            }

          if(waybillForm.getElementDate() != null ){
              waybillForm.getElementDate().forEach(elementDate -> {
                  waybillFormInstance.getElementDateValue().forEach(elementDateValue -> {
                      if(elementDate.getId().equals(elementDateValue.getElementDate().getId())){
                          elementDateValue.setElementDate(elementDate);
                          elementDateValue.setWaybillFormDateValueId(waybillFormInstance.getId());
                          elementDateRepository.save(elementDateValue);
                      }
                  });
              });
          }

            if (waybillFormInstance.getElementDoubleValue() != null) {
                waybillForm.getElementDouble().forEach(elementDouble -> {
                    waybillFormInstance.getElementDoubleValue().forEach(elementDoubleValue -> {
                        if(elementDouble.getId().equals(elementDoubleValue.getElementDouble().getId())){
                            elementDoubleValue.setElementDouble(elementDouble);
                            elementDoubleValue.setWaybillFormDoubleValueId(waybillFormInstance.getId());
                            elementDoubleRepository.save(elementDoubleValue);
                        }
                    });
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
