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
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class Services extends com.callcenter.domain.Collection<Service> {

    public Services(Collection<Service> services) {
        super(services);
    }


    public RecordingLibraryService getRecordingLibraryService() {
        return (RecordingLibraryService) returnEntityIfConditionIsTrue(new ConditionEvaluator<Service>() {
            @Override
            public boolean evaluate(final Service entity) {
                return entity instanceof RecordingLibraryService;
            }
        });
    }
}
