package com.fortex.backend.waybillinstance.waybillform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api/waybill")
public class WaybillFormControllerInstance {

    @Autowired
    private WaybillFormInstanceService waybillFormService;


    @PostMapping(value = "/waybillId/{id}")
    public WaybillFormInstance createNewWaybill(@PathVariable Long id, @RequestBody WaybillFormInstance waybillForm){
        return waybillFormService.createNewWaybill(id, waybillForm);
    }

    @GetMapping(value="/{id}")
    public WaybillFormInstance findWaybillById(@PathVariable Long id){
        return waybillFormService.findWaybillById(id);
    }

}
