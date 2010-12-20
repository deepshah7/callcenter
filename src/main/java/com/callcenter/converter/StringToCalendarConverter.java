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
package com.callcenter.converter;

import com.callcenter.util.Constants;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class StringToCalendarConverter extends PropertyEditorSupport {

    private final SimpleDateFormat sdf = new SimpleDateFormat(Constants.Defaults.DATE_FORMAT);

    public Calendar toCalendar(final String date) {
        final Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAsText() {
        final Calendar calendar = (Calendar) getValue();

        if (null != calendar) {
            return sdf.format(calendar.getTime());
        }
        return "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAsText(final String text) {
        final Calendar calendar = Calendar.getInstance();

        try {
            // Date Format with time
            final Date date = sdf.parse(text);
            calendar.setTime(date);
            setValue(calendar);
        } catch (final ParseException pe) {
            pe.printStackTrace();
            setValue(null);
        }
    }
}
