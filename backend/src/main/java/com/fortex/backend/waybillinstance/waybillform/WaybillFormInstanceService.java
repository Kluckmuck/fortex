package com.fortex.backend.waybillinstance.waybillform;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fortex.backend.waybillinstance.elements.ElementDateValue;
import com.fortex.backend.waybillinstance.elements.ElementDateValueRepository;
import com.fortex.backend.waybillinstance.elements.ElementDoubleValueRepository;
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


    public WaybillFormInstance createNewWaybillForm(WaybillFormInstance waybillForm){
        /**
         * Add each element and sets waybillform id.
         * TODO: solve ManyToOne annotation
         */

        waybillFormInstanceRepository.save(waybillForm);
        waybillForm.getElementDateValue().forEach(element -> {
            element.setWaybillFormDateId(waybillForm.getId());
            elementDateRepository.save(element);
        });

        waybillForm.getElementDoubleValue().forEach(elementDouble ->{
            elementDouble.setWaybillFormDoubleId(waybillForm.getId());
            elementDoubleRepository.save(elementDouble);
        });

        waybillForm.getElementStringValue().forEach(elementString ->{
            elementString.setWaybillFormStringId(waybillForm.getId());
            elementStringRepository.save(elementString);
        });
        return waybillForm;
    }


    public List<WaybillForm> getAllWaybillForms(){
        return waybillFormRepository.findAll();
    }


	public WaybillForm findWaybillFormById(Long id) {
		return waybillFormRepository.findWaybillFormById(id) ;
	}

}
