package com.callcenter.domain;

import com.callcenter.domain.Role;
import com.callcenter.domain.Service;
import java.lang.Boolean;
import java.lang.Integer;
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
    
    public Integer Role.getTimeout() {
        return this.timeout;
    }
    
    public void Role.setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
    
    public Boolean Role.getCanAddGroups() {
        return this.canAddGroups;
    }
    
    public void Role.setCanAddGroups(Boolean canAddGroups) {
        this.canAddGroups = canAddGroups;
    }
    
    public Boolean Role.getCanAddUsers() {
        return this.canAddUsers;
    }
    
    public void Role.setCanAddUsers(Boolean canAddUsers) {
        this.canAddUsers = canAddUsers;
    }
    
    public Boolean Role.getCanAddRoles() {
        return this.canAddRoles;
    }
    
    public void Role.setCanAddRoles(Boolean canAddRoles) {
        this.canAddRoles = canAddRoles;
    }
    
    public Set<Role> Role.getAssignableRoles() {
        return this.assignableRoles;
    }
    
    public void Role.setAssignableRoles(Set<Role> assignableRoles) {
        this.assignableRoles = assignableRoles;
    }
    
    public Set<Service> Role.getServices() {
        return this.services;
    }
    
    public void Role.setServices(Set<Service> services) {
        this.services = services;
    }
    
}
