package com.callcenter.domain;

import com.callcenter.domain.Field.Type;
import java.lang.Boolean;
import java.lang.String;

privileged aspect Field_Roo_JavaBean {
    
    public String Field.getName() {
        return this.name;
    }
    
    public void Field.setName(String name) {
        this.name = name;
    }
    
    public String Field.getDescription() {
        return this.description;
    }
    
    public void Field.setDescription(String description) {
        this.description = description;
    }
    
    public Boolean Field.getAvailableByDefault() {
        return this.availableByDefault;
    }
    
    public void Field.setAvailableByDefault(Boolean availableByDefault) {
        this.availableByDefault = availableByDefault;
    }
    
    public Type Field.getType() {
        return this.type;
    }
    
    public void Field.setType(Type type) {
        this.type = type;
    }
    
}
