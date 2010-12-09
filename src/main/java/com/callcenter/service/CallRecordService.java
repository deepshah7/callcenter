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
package com.callcenter.service;

import com.callcenter.domain.CallRecord;
import com.callcenter.domain.RecordingLibraryService;
import com.callcenter.domain.Restrictions;
import com.callcenter.domain.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
@Service
@Transactional
public class CallRecordService {

    public List<CallRecord> getCallRecordsFilteredByRoleAndSearchCriteria(final CallRecord callRecord,
                                                                          final Role role) {
        final RecordingLibraryService recordingLibraryService = role.getRecordingLibraryService();
        return CallRecord.findAllByExampleAndRestrictions(callRecord,
                new Restrictions(recordingLibraryService.getRestrictions()));
    }
}
