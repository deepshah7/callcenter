package com.callcenter.domain;

import com.callcenter.domain.Role;
import java.lang.String;
import java.util.Locale;

privileged aspect User_Roo_JavaBean {
    
    public String User.getName() {
        return this.name;
    }
    
    public void User.setName(String name) {
        this.name = name;
    }
    
    public String User.getPassword() {
        return this.password;
    }
    
    public void User.setPassword(String password) {
        this.password = password;
    }
    
    public Locale User.getLanguage() {
        return this.language;
    }
    
    public void User.setLanguage(Locale language) {
        this.language = language;
    }
    
    public Role User.getRole() {
        return this.role;
    }
    
    public void User.setRole(Role role) {
        this.role = role;
    }
    
}
