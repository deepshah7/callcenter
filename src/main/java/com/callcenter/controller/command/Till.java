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

import com.callcenter.domain.Restriction;
import com.callcenter.util.Constants;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.Calendar;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class Till {

    private Type type;

    private Calendar dateAndTime;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Calendar getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Calendar dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public void addSearchFilter(DetachedCriteria criteria) {
        Calendar tillDate = Calendar.getInstance();
        if(type == Type.DATE_AND_TIME) {
            tillDate = dateAndTime;
        }
        criteria.add(Restrictions.le(Constants.CallRecord.CALL_TIME_PROPERTY_NAME, tillDate));
    }

    enum Type {
        NOW, DATE_AND_TIME
    }
}
