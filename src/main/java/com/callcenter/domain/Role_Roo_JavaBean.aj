package com.callcenter.domain;

import com.callcenter.domain.Field;
import com.callcenter.domain.Restriction;
import java.lang.String;
import java.util.Locale;
import java.util.Set;

privileged aspect Role_Roo_JavaBean {
    
    public String Role.getName() {
        return this.name;
    }
    
    public void Role.setName(String name) {
        this.name = name;
    }
    
    public String Role.getDescription() {
        return this.description;
    }
    
    public void Role.setDescription(String description) {
        this.description = description;
    }
    
    public Locale Role.getLanguage() {
        return this.language;
    }
    
    public void Role.setLanguage(Locale language) {
        this.language = language;
    }
    
    public Set<Field> Role.getAllowedFields() {
        return this.allowedFields;
    }
    
    public void Role.setAllowedFields(Set<Field> allowedFields) {
        this.allowedFields = allowedFields;
    }
    
    public Set<Restriction> Role.getRestrictions() {
        return this.restrictions;
    }
    
    public void Role.setRestrictions(Set<Restriction> restrictions) {
        this.restrictions = restrictions;
    }
    
}
