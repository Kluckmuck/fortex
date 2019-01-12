package com.fortex.backend.waybill.waybillform;

import java.util.List;

import com.fortex.backend.exceptions.ResourceNotFoundException;
import com.fortex.backend.organization.OrganizationRepository;
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

    @Autowired
    OrganizationRepository organizationRepository;

    public WaybillForm createNewWaybillForm(Long orgId, WaybillForm waybillForm) {
       
        return organizationRepository.findById(orgId).map(organization ->{
            waybillForm.setOrganization(organization);
            if (waybillForm.getElementDate() != null) {
                waybillForm.getElementDate().forEach(element -> {
                    element.setWaybillFormDateId(waybillForm.getId());
                    elementDateRepository.save(element);
                });
            }
            if (waybillForm.getElementDouble() != null) {
                waybillForm.getElementDouble().forEach(elementDouble -> {
                    elementDouble.setWaybillFormDoubleId(waybillForm.getId());
                    elementDoubleRepository.save(elementDouble);
                });
            }
    
            if (waybillForm.getElementString() != null) {
                waybillForm.getElementString().forEach(elementString -> {
                    elementString.setWaybillFormStringId(waybillForm.getId());
                    elementStringRepository.save(elementString);
                });
            }
            return waybillFormRepository.save(waybillForm);
        }).orElseThrow(() -> new ResourceNotFoundException("error"));
    }

    

    public List<WaybillForm> getAllWaybillForms() {
        return waybillFormRepository.findAll();
    }

    public WaybillForm findWaybillFormById(Long id) {
        return waybillFormRepository.findWaybillFormById(id);
    }

}
