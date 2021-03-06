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

import com.callcenter.domain.CallRecord;
import org.hibernate.criterion.DetachedCriteria;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class SearchCommand {

    private Type type;

    private From from;

    private Till till;

    private Find find;

    private HowLong howLong;

    private Whom whom;

    private String freeForm;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public Till getTill() {
        return till;
    }

    public void setTill(Till till) {
        this.till = till;
    }

    public Find getFind() {
        return find;
    }

    public void setFind(Find find) {
        this.find = find;
    }

    public HowLong getHowLong() {
        return howLong;
    }

    public void setHowLong(HowLong howLong) {
        this.howLong = howLong;
    }

    public Whom getWhom() {
        return whom;
    }

    public void setWhom(Whom whom) {
        this.whom = whom;
    }

    public String getFreeForm() {
        return freeForm;
    }

    public void setFreeForm(String freeForm) {
        this.freeForm = freeForm;
    }

    public DetachedCriteria getCriteria() {
        final DetachedCriteria criteria = DetachedCriteria.forClass(CallRecord.class);
        if(type == Type.FREE_FORM) {
            return criteria;
        }
        from.addSearchFilter(criteria);
        till.addSearchFilter(criteria);
        find.addSearchFilter(criteria);
        howLong.addSearchFilter(criteria);
        whom.addSearchFilter(criteria);
        return criteria;
    }

    enum Type {
        WIZARD, FREE_FORM
    }
}
