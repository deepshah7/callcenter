/*
 * Copyright 2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.callcenter.domain;

import com.callcenter.util.Constants;
import org.hibernate.annotations.*;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.security.Provider;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
@Entity
@Table(name = "roles")
@RooJavaBean
@RooEntity(finders = {"findRolesByName"})
public class Role {
    private String name;

    private String description;

    private Locale language;

    private Integer timeout = Constants.Defaults.ROLE_TIMEOUT;

    private Boolean canAddGroups;

    private Boolean canAddUsers;

    private Boolean canAddRoles;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "role_assignables", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "assignable_role_id"))
    private Set<Role> assignableRoles = new HashSet<Role>();

    @ManyToMany(targetEntity = Service.class)
    @JoinTable(name = "role_services", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Service> services = new HashSet<Service>();


    public static Role findRoleByName(final String name) {
        return (Role) findRolesByName(name).getSingleResult();
    }

    public RecordingLibraryService getRecordingLibraryService() {
        return (RecordingLibraryService) services.iterator().next();
    }
}
