package com.callcenter.domain;

import com.callcenter.domain.Group;
import com.callcenter.domain.User;
import java.lang.String;
import java.util.Set;

privileged aspect Group_Roo_JavaBean {
    
    public String Group.getName() {
        return this.name;
    }
    
    public void Group.setName(String name) {
        this.name = name;
    }
    
    public String Group.getNumber() {
        return this.number;
    }
    
    public void Group.setNumber(String number) {
        this.number = number;
    }
    
    public Set<User> Group.getMembers() {
        return this.members;
    }
    
    public void Group.setMembers(Set<User> members) {
        this.members = members;
    }
    
    public Set<Group> Group.getGroups() {
        return this.groups;
    }
    
    public void Group.setGroups(Set<Group> groups) {
        this.groups = groups;
    }
    
}
