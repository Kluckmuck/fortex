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


    public WaybillFormInstance createNewWaybill(WaybillFormInstance waybill){
        /**
         * Add each element and sets waybillform id.
         * TODO: solve ManyToOne annotation
         */

        waybillFormInstanceRepository.save(waybill);
        waybill.getElementDateValue().forEach(element -> {
            element.setWaybillFormDateValueId(waybill.getId());
            elementDateRepository.save(element);
        });

        waybill.getElementDoubleValue().forEach(elementDouble ->{
            elementDouble.setWaybillFormDoubleValueId(waybill.getId());
            elementDoubleRepository.save(elementDouble);
        });

        waybill.getElementStringValue().forEach(elementString ->{
            elementString.setWaybillFormStringValueId(waybill.getId());
            elementStringRepository.save(elementString);
        });
        return waybill;
    }

	public WaybillFormInstance findWaybillById(Long id) {
		return waybillFormInstanceRepository.findWaybillById(id) ;
	}

}
