package com.fortex.backend.waybill.waybillform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api/waybillform")
public class WaybillFormController {

    @Autowired
    private WaybillFormService waybillFormService;


    @PostMapping
    public WaybillForm createNewWaybillForm(@RequestBody WaybillForm waybillForm){
        return waybillFormService.createNewWaybillForm(waybillForm);

    }

    @GetMapping
    public List<WaybillForm> getAllWaybillForms(){
        return waybillFormService.getAllWaybillForms();
    }


}
