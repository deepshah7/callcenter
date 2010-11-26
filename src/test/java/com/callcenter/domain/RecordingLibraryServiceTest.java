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

import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class RecordingLibraryServiceTest {
    @Test
    public void shouldReturnAllTheItemsFromTheRestricationsIfListIsEmpty() {
        final RecordingLibraryService recordingLibraryService = new RecordingLibraryService();
        assertTrue(recordingLibraryService.getRestrictionList().isEmpty());

        final Restriction restriction = new Restriction();
        recordingLibraryService.getRestrictions().add(restriction);

        final List<Restriction> restrictionList = recordingLibraryService.getRestrictionList();
        assertTrue(restrictionList.contains(restriction));
        assertEquals(1, restrictionList.size());
    }
    
    @Test
    public void shouldReturnTheSameListIfRestrictionsListIsNotEmpty() {
        final RecordingLibraryService recordingLibraryService = new RecordingLibraryService();
        final Restriction restriction = new Restriction();
        recordingLibraryService.getRestrictions().add(restriction);

        final List<Restriction> restrictionList = recordingLibraryService.getRestrictionList();
        assertEquals(1, restrictionList.size());

        final Restriction restriction1 = new Restriction();
        recordingLibraryService.getRestrictions().add(restriction1);

        final List<Restriction> restrictionList1 = recordingLibraryService.getRestrictionList();
        assertEquals(1, restrictionList1.size());
        assertFalse(restrictionList1.contains(restriction1));
    }
}
