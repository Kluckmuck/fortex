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
@RequestMapping(value ="/api/waybillform")
public class WaybillFormControllerInstance {

    @Autowired
    private WaybillFormInstanceService waybillFormService;


    @PostMapping
    public WaybillFormInstance createNewWaybillForm(@RequestBody WaybillFormInstance waybillForm){
        return waybillFormService.createNewWaybillForm(waybillForm);

    }

    @GetMapping
    public List<WaybillFormInstance> getAllWaybillForms(){
        return waybillFormService.getAllWaybillForms();
    }

    @GetMapping(value="/{id}")
    public WaybillFormInstance findWaybillFormById(@PathVariable Long id){
        return waybillFormService.findWaybillFormById(id);
    }

}
