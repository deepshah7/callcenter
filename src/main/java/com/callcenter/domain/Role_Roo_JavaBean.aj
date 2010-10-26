package com.callcenter.domain;

import java.lang.String;
import java.util.Locale;

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
    
}
