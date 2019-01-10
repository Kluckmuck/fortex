package com.fortex.backend.waybillinstance.elmentfactory;

import java.util.Set;

import com.fortex.backend.waybill.elements.ElementString;
import com.fortex.backend.waybillinstance.elements.ElementStringValue;

/**
 * ElementStringFactory
 */
public class ElementFactory extends AbstractFactory {

    @Override
    public ElementValue getElementType(String type) {

        if(type ==  null){
            return null;
        }
        if(type.equalsIgnoreCase("STRING")){
            return new ElementStringValue();
        }

        return null;
    }

 

    
}