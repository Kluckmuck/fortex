package com.fortex.backend.waybill.waybillform;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fortex.backend.waybill.elements.ElementDate;
import com.fortex.backend.waybill.elements.ElementDateRepository;
import com.fortex.backend.waybill.elements.ElementDoubleRepository;
import com.fortex.backend.waybill.elements.ElementStringRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaybillFormService {


    @Autowired
    WaybillFormRepository waybillFormRepository;

    @Autowired
    ElementDateRepository elementDateRepository;

    @Autowired
    ElementDoubleRepository elementDoubleRepository;

    @Autowired
    ElementStringRepository elementStringRepository;


    public WaybillForm createNewWaybillForm(WaybillForm waybillForm){
        /**
         * Add each element and sets waybillform id.
         * TODO: solve ManyToOne annotation
         */

        waybillFormRepository.save(waybillForm); //Saving

        waybillForm.getElementDate().forEach(element -> { 
            element.setWaybillFormDateId(waybillForm.getId());
            elementDateRepository.save(element);
        });
        
        waybillForm.getElementDouble().forEach(elementDouble ->{
            elementDouble.setWaybillFormDoubleId(waybillForm.getId());
            elementDoubleRepository.save(elementDouble);
        });
        
        waybillForm.getElementString().forEach(elementString ->{
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
