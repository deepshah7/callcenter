package com.callcenter.domain;

import java.lang.String;

privileged aspect Service_Roo_JavaBean {
    
    public String Service.getName() {
        return this.name;
    }
    
    public void Service.setName(String name) {
        this.name = name;
    }
    
}
