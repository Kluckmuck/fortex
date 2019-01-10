package com.fortex.backend.waybillinstance.elmentfactory;

import java.util.Set;

import com.fortex.backend.waybill.elements.ElementString;

/**
 * AbstractFactory
 */
public abstract class AbstractFactory {
    abstract Set<ElementString> getString(String name);
    
}