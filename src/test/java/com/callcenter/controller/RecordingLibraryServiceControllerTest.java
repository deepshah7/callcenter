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
package com.callcenter.controller;

import com.callcenter.domain.Field;
import com.callcenter.domain.RecordingLibraryService;
import com.callcenter.editor.CustomCalendarEditor;
import mockit.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;

import java.util.ArrayList;
import java.util.Calendar;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertSame;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class RecordingLibraryServiceControllerTest {

    private RecordingLibraryServiceController controller;

    @Before
    public void setUp() {
        controller = new RecordingLibraryServiceController();
    }
    
    @Test
    public void shouldPrepareTheRestrictionsBeforePersist(final @NonStrict RecordingLibraryService service) {
        controller.create(service);
        new VerificationsInOrder() {
            {
                service.prepareRestrictions();
                service.persist();
            }
        };
    }

    @Test
    public void shouldReturnTheUrlOfToShowTheService(final @NonStrict RecordingLibraryService service) {
        new NonStrictExpectations() {
            {
                service.getId(); returns(1233L);
            }
        };
        assertEquals("redirect:/recordinglibrary/1233", controller.create(service));
    }

    @Test
    public void shouldSetAllFieldsInTheModel() {
        final ArrayList<Field> fields = new ArrayList<Field>();
        new NonStrictExpectations() {
            @Mocked
            Field field = null;
            @Mocked RecordingLibraryService recordingLibraryService = null;
            {
                Field.findAllFields(); returns(fields);
            }
        };
        final ModelMap modelMap = new ModelMap();
        controller.createForm(modelMap);
        assertSame(fields, modelMap.get("fields"));
    }

    @Test
    public void shouldReturnTheCreateForm() {
        new NonStrictExpectations() {
            @Mocked
            Field field = null;
            @Mocked RecordingLibraryService recordingLibraryService = null;
            {
            }
        };
        final ModelMap modelMap = new ModelMap();
        assertEquals("recordinglibrary/create", controller.createForm(modelMap));
        assertNotNull(modelMap.get("service"));
    }

    @Test
    public void shouldGetTheServiceBasedOnTheIdentifier(final @NonStrict RecordingLibraryService recordingLibraryService) {
        final RecordingLibraryService service = new RecordingLibraryService();
        new NonStrictExpectations() {
            {
                RecordingLibraryService.findRecordingLibraryService(1233L); returns(service);
            }
        };
        final ModelMap map = new ModelMap();
        controller.show(1233L, map);
        assertSame(service, map.get("service"));
    }

    @Test
    public void shouldReturnTheShowView(final @NonStrict RecordingLibraryService recordingLibraryService) {
        assertEquals("recordinglibrary/show", controller.show(1233L, new ModelMap()));
    }

    @Test
    public void shouldPopulateAllServicesInTheModelMap(final @NonStrict RecordingLibraryService recordingLibraryService) {
        final ArrayList<RecordingLibraryService> services = new ArrayList<RecordingLibraryService>();
        new NonStrictExpectations() {
            {
                RecordingLibraryService.findAllRecordingLibraryServices(); returns(services);
            }
        };
        final ModelMap map = new ModelMap();
        controller.list(map);
        assertSame(services, map.get("services"));
    }

    @Test
    public void shouldReturnTheListView(final @NonStrict RecordingLibraryService recordingLibraryService) {
        assertEquals("recordinglibrary/list", controller.list(new ModelMap()));
    }

    @Test
    public void shouldRegiesterTheCalenderConverter(final @NonStrict WebDataBinder webDataBinder) {

        controller.initDataBinder(webDataBinder);

        new Verifications() {
            {
                webDataBinder.registerCustomEditor(Calendar.class, (CustomCalendarEditor)any);
            }
        };
    }
}
