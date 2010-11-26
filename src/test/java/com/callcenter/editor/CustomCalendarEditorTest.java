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
package com.callcenter.editor;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class CustomCalendarEditorTest {

    private CustomCalendarEditor editor;

    @Before
    public void setUp() {
        editor = new CustomCalendarEditor();
    }

    @Test
    public void shouldNotDoAnythingIfValueIsNull() {
        editor.setAsText(null);
        assertNull(editor.getValue());
    }
    
    @Test
    public void shouldSetTheValueAsACalenderForAValidDateString() {
        editor.setAsText("12/31/2010");

        final Calendar calendar = (Calendar) editor.getValue();
        assertEquals("12/31/2010", new SimpleDateFormat("MM/dd/yyyy").format(calendar.getTime()));
    }

    @Test
    public void shouldReturnNullIfValueIsNull() {
        assertEquals("", editor.getAsText());
    }

    @Test
    public void shouldReturnValueAsString() {
        final Calendar calendar = Calendar.getInstance();
        final Date date = new Date();
        calendar.setTime(date);
        editor.setValue(calendar);
        assertEquals(new SimpleDateFormat("MM/dd/yyyy").format(date), editor.getAsText());
    }
}
