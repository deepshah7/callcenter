package com.callcenter.domain;

import com.callcenter.domain.Field;
import com.callcenter.domain.Restriction.Type;
import com.callcenter.domain.Role;
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
    
    public Role Restriction.getRole() {
        return this.role;
    }
    
    public void Restriction.setRole(Role role) {
        this.role = role;
    }
    
    public List<String> Restriction.getValues() {
        return this.values;
    }
    
    public void Restriction.setValues(List<String> values) {
        this.values = values;
    }
    
}
