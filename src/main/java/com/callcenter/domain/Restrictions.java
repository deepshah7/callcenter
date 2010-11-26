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

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class Restrictions extends Collection<Restriction> {

    public Restrictions(final java.util.Collection<Restriction> entities) {
        super(entities);
    }

    public void convertCSVToList() {

        doInLoop(new ExpressionEvaluator<Restriction>() {

            @Override
            public void evaluate(final Restriction entity) {
                entity.convertCSVToList();
            }
        });
    }

    public void trim() {
        getEntities().removeAll(returnEntitiesIfConditionIsTrue(new ConditionEvaluator<Restriction>() {

            @Override
            public boolean evaluate(final Restriction entity) {
                return null == entity.getField() || null == entity.getField().getId();
            }
        }));
    }

    public void setupRelationship(final RecordingLibraryService recordingLibraryService) {
        doInLoop(new ExpressionEvaluator<Restriction>() {

            @Override
            public void evaluate(Restriction entity) {
                entity.setService(recordingLibraryService);
            }
        });
    }
}
