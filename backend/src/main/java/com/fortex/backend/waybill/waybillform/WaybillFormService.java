package com.fortex.backend.waybill.waybillform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaybillFormService {


    @Autowired
    WaybillFormRepository waybillFormRepository;


    public WaybillForm createNewWaybillForm(WaybillForm waybillForm){
        return waybillFormRepository.save(waybillForm);
    }


    public List<WaybillForm> getAllWaybillForms(){
        return waybillFormRepository.findAll();
    }

}
