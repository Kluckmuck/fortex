package com.fortex.backend.waybill.waybillform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api/waybillform")
public class WaybillFormController {

    @Autowired
    private WaybillFormService waybillFormService;


    @PostMapping("/orgid/{orgId}")
    public WaybillForm createNewWaybillFormWithOrganization(@PathVariable Long orgId, @RequestBody WaybillForm waybillForm){
        return waybillFormService.createNewWaybillForm(orgId,waybillForm);
    }


    @GetMapping
    public List<WaybillForm> getAllWaybillForms(){
        return waybillFormService.getAllWaybillForms();
    }

    @GetMapping(value="/{id}")
    public WaybillForm findWaybillFormById(@PathVariable Long id){
        return waybillFormService.findWaybillFormById(id);
    }

}
