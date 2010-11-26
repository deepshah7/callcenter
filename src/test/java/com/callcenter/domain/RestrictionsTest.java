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

import mockit.NonStrict;
import mockit.NonStrictExpectations;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class RestrictionsTest {

    @Test
    public void shouldRemoveTheRestrictionsThatHaveNullFields(final @NonStrict Field field) {
        final Restriction restriction1 = new Restriction();
        final Restriction restriction2 = new Restriction();
        restriction2.setField(new Field());
        final ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
        restrictions.add(restriction1);
        restrictions.add(restriction2);
        final Restrictions restrictionCollection = new Restrictions(restrictions);
        restrictionCollection.prepare(new RecordingLibraryService());

        assertTrue(restrictionCollection.getEntities().contains(restriction2));
        assertFalse(restrictionCollection.getEntities().contains(restriction1));
    }

    @Test
    public void shouldSetUpTheServiceReferenceInTheRestriction(final @NonStrict Field field) {
        final Restriction restriction2 = new Restriction();
        restriction2.setField(new Field());
        final ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
        restrictions.add(restriction2);
        final Restrictions restrictionCollection = new Restrictions(restrictions);
        final RecordingLibraryService service = new RecordingLibraryService();
        restrictionCollection.prepare(service);

        assertSame(service, restriction2.getService());
    }

    @Test
    public void shouldSetUpTheProperFieldInTheRestriction(final @NonStrict Field field) {
        final Restriction restriction2 = new Restriction();
        final Field field1 = new Field();
        final Field field2 = new Field();
        restriction2.setField(field1);
        final ArrayList<Restriction> restrictions = new ArrayList<Restriction>();
        restrictions.add(restriction2);
        final Restrictions restrictionCollection = new Restrictions(restrictions);
        final RecordingLibraryService service = new RecordingLibraryService();

        new NonStrictExpectations() {
            {
                field.getId(); returns(1233L);
                Field.findField(1233L);
                returns(field2);
            }
        };

        restrictionCollection.prepare(service);

        assertSame(field2, restriction2.getField());
    }
}
