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

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
@Entity
@Table(name = "restrictions")
@RooJavaBean
@RooEntity
public class Restriction {
    @ManyToOne(targetEntity = Field.class, optional = false)
    @JoinColumn(name = "field_id")
    private Field field;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToOne(targetEntity = Service.class, optional = false)
    @JoinColumn(name = "service_id")
    private Service service;

    @ElementCollection(targetClass = String.class)
    @CollectionTable(name = "restriction_values", joinColumns =  @JoinColumn(name = "restriction_id"))
    @OrderColumn(name = "value_index")
    @Column(name = "value")
    private List<String> values = new ArrayList<String>();

    @Transient
    private String comaSeperatedValues;

    public enum Type {
        IN,
        BETWEEN;
    }
}
