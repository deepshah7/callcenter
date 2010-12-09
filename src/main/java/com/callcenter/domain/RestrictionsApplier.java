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

import org.hibernate.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class RestrictionsApplier {
    private final List<RestrictionApplier> restrictionAppliers = new ArrayList<RestrictionApplier>();

    public RestrictionsApplier(final Criteria searchCriteria) {
        restrictionAppliers.add(new InRestrictionApplier(searchCriteria));
        restrictionAppliers.add(new BetweenRestrictionApplier(searchCriteria));
    }

    public void apply(final Restriction restriction) {
        for(final RestrictionApplier restrictionApplier : restrictionAppliers) {
            if(restrictionApplier.canApply(restriction)) {
                restrictionApplier.apply(restriction);
                return;
            }
        }
        throw new IllegalArgumentException("Could not apply restriction of type: " + restriction.getType());
    }
}
