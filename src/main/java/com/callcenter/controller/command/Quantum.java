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
package com.callcenter.controller.command;

import com.callcenter.util.Constants;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class Quantum {

    private Type type;

    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void addSearchFilter(DetachedCriteria criteria) {
        final Calendar calendar = Calendar.getInstance();
        calendar.add(type.getField(), value * type.getMultiplicationFactor());
        criteria.add(Restrictions.ge(Constants.CallRecord.CALL_TIME_PROPERTY_NAME, calendar));
    }

    enum Type {
        HOURS(Calendar.HOUR, -1),DAYS(Calendar.DATE, -1),WEEKS(Calendar.DATE, -7),MONTHS(Calendar.MONTH, -1);
        private int field;
        private int multiplicationFactor;

        Type(int field, int multiplicationFactor) {
            this.field = field;
            this.multiplicationFactor = multiplicationFactor;
        }

        public int getField() {
            return field;
        }

        public int getMultiplicationFactor() {
            return multiplicationFactor;
        }
    }
}
