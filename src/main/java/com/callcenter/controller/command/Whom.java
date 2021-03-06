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

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class Whom {

    private Type type;

    private String number = "*";

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void addSearchFilter(DetachedCriteria criteria) {
        String actualNumber = number.replaceAll("\\*", "%").replaceAll("\\?", "_");
        if(type == Whom.Type.TO_AND_FROM) {
            criteria.add(Restrictions.or(Restrictions.ilike(Constants.CallRecord.CALLED_ID_PROPERTY_NAME, actualNumber),
                    Restrictions.ilike(Constants.CallRecord.CALLER_ID_PROPERTY_NAME, actualNumber)));
            return;
        }
        if(type == Whom.Type.TO) {
            criteria.add(Restrictions.ilike(Constants.CallRecord.CALLED_ID_PROPERTY_NAME, actualNumber));
            return;
        }
        criteria.add(Restrictions.ilike(Constants.CallRecord.CALLER_ID_PROPERTY_NAME, actualNumber));
    }

    enum Type {
        TO_AND_FROM, TO, FROM
    }
}
