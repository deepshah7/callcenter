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
public class Find {

    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void addSearchFilter(DetachedCriteria criteria) {
        if(type == Find.Type.ALL) return;
        if(type == Find.Type.INCOMING) {
            criteria.add(Restrictions.eq(Constants.CallRecord.OUTGOING_PROPERTY_NAME, false));
            return;
        }
        criteria.add(Restrictions.eq(Constants.CallRecord.OUTGOING_PROPERTY_NAME, true));
    }

    enum Type {
        ALL, INCOMING, OUTGOING
    }
}
