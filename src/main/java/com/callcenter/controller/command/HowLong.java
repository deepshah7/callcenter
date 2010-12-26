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
public class HowLong {

    private Type type;

    private Integer value;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void addSearchFilter(DetachedCriteria criteria) {
        if(type == HowLong.Type.ANY) return;
        /*
         TODO: uncomment the following lines when we support the call duration.
        if(type == HowLong.Type.GREATER_THAN) {
            criteria.add(Restrictions.ge(Constants.CallRecord.DURATION_PROPERTY_NAME, value));
            return;
        }
        criteria.add(Restrictions.le(Constants.CallRecord.DURATION_PROPERTY_NAME, value));
        */
    }

    enum Type {
        ANY, GREATER_THAN, LESS_THAN
    }
}
