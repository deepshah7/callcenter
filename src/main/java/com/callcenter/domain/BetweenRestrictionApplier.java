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

import com.callcenter.converter.StringToCalendarConverter;
import org.hibernate.Criteria;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class BetweenRestrictionApplier implements RestrictionApplier {
    private Criteria searchCriteria;

    public BetweenRestrictionApplier(Criteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    @Override
    public boolean canApply(final Restriction restriction) {
        return restriction.getType() == Restriction.Type.BETWEEN;
    }

    @Override
    public void apply(final Restriction restriction) {
        Object start = restriction.getValues().get(0);
        Object end = restriction.getValues().get(1);
        if(restriction.isOnCalendarField()) {
            final StringToCalendarConverter stringToCalendarConverter = new StringToCalendarConverter();
            start = stringToCalendarConverter.toCalendar(start.toString());
            end = stringToCalendarConverter.toCalendar(end.toString());
        }
        searchCriteria.add(org.hibernate.criterion.Restrictions.between(restriction.getFieldName(), start, end));
    }
}
