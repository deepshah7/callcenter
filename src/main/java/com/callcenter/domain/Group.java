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

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
@Entity
@Table(name = "groups")
@RooJavaBean
@RooEntity
public class Group {
    private String name;

    private String number;

    @ManyToMany(targetEntity = User.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "group_members", joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> members = new HashSet<User>();

    @ManyToMany(targetEntity = Group.class, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "group_member_groups", joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "other_group_id"))
    private Set<Group> groups = new HashSet<Group>();
}
