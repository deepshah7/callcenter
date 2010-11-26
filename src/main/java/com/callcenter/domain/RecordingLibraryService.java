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
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
@Entity
@RooJavaBean
@RooEntity
@Table(name = "recording_library_services")
public class RecordingLibraryService extends Service{

    private String recordingType;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Calendar retainFrom;

    @OneToMany(targetEntity = Restriction.class, cascade = CascadeType.ALL, mappedBy = "service", orphanRemoval = true)
    private Set<Restriction> restrictions = new HashSet<Restriction>();

    @ManyToMany(targetEntity = Field.class, cascade = CascadeType.ALL)
    @JoinTable(name = "recording_library_service_available_fields",
            joinColumns = @JoinColumn(name = "recording_library_service_id"),
            inverseJoinColumns = @JoinColumn(name = "field_id"))
    private Set<Field> availableFields = new HashSet<Field>();
}
