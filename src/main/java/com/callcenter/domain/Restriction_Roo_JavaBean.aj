package com.callcenter.domain;

import com.callcenter.domain.Field;
import com.callcenter.domain.Restriction.Type;
import com.callcenter.domain.Service;
import java.lang.String;
import java.util.List;

privileged aspect Restriction_Roo_JavaBean {
    
    public Field Restriction.getField() {
        return this.field;
    }
    
    public void Restriction.setField(Field field) {
        this.field = field;
    }
    
    public Type Restriction.getType() {
        return this.type;
    }
    
    public void Restriction.setType(Type type) {
        this.type = type;
    }
    
    public Service Restriction.getService() {
        return this.service;
    }
    
    public void Restriction.setService(Service service) {
        this.service = service;
    }
    
    public List<String> Restriction.getValues() {
        return this.values;
    }
    
    public void Restriction.setValues(List<String> values) {
        this.values = values;
    }
    
    public String Restriction.getComaSeperatedValues() {
        return this.comaSeperatedValues;
    }
    
}
