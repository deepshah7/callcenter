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

import com.callcenter.util.Constants;
import org.springframework.beans.propertyeditors.CustomDateEditor;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class CustomCalendarEditor extends CustomDateEditor {

    public CustomCalendarEditor() {
        super(new SimpleDateFormat(Constants.Defaults.DATE_FORMAT), true);
    }

    @Override
    public void setAsText(final String text) throws IllegalArgumentException {
        super.setAsText(text);
        if(null == getValue()) return ;
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime((Date) getValue());
        setValue(calendar);
    }

    @Override
    public String getAsText() {
        final Calendar calendar = (Calendar) getValue();
        if(null == calendar) return "";
        return new SimpleDateFormat(Constants.Defaults.DATE_FORMAT).format(calendar.getTime());
    }
}
