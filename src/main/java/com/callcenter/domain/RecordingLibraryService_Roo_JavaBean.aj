package com.callcenter.domain;

import com.callcenter.domain.Field;
import com.callcenter.domain.Restriction;
import java.lang.String;
import java.util.Calendar;
import java.util.Set;

privileged aspect RecordingLibraryService_Roo_JavaBean {
    
    public String RecordingLibraryService.getRecordingType() {
        return this.recordingType;
    }
    
    public void RecordingLibraryService.setRecordingType(String recordingType) {
        this.recordingType = recordingType;
    }
    
    public Calendar RecordingLibraryService.getRetainFrom() {
        return this.retainFrom;
    }
    
    public void RecordingLibraryService.setRetainFrom(Calendar retainFrom) {
        this.retainFrom = retainFrom;
    }
    
    public Set<Restriction> RecordingLibraryService.getRestrictions() {
        return this.restrictions;
    }
    
    public void RecordingLibraryService.setRestrictions(Set<Restriction> restrictions) {
        this.restrictions = restrictions;
    }
    
    public Set<Field> RecordingLibraryService.getAvailableFields() {
        return this.availableFields;
    }
    
    public void RecordingLibraryService.setAvailableFields(Set<Field> availableFields) {
        this.availableFields = availableFields;
    }
    
}
