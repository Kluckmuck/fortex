package com.fortex.backend.waybill.waybillform;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fortex.backend.waybill.elements.ElementDate;
import com.fortex.backend.waybill.elements.ElementDateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaybillFormService {


    @Autowired
    WaybillFormRepository waybillFormRepository;

    @Autowired
    ElementDateRepository elementDateRepository;


    public WaybillForm createNewWaybillForm(WaybillForm waybillForm){

        waybillForm.getElementDate().forEach(ao -> {
            elementDateRepository.save(ao);
        });
        return waybillFormRepository.save(waybillForm);
    }


    public List<WaybillForm> getAllWaybillForms(){
        return waybillFormRepository.findAll();
    }

}
