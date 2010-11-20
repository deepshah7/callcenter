package com.callcenter.domain;

import com.callcenter.domain.RecordingLibraryService;
import java.lang.Long;
import java.util.List;

privileged aspect RecordingLibraryService_Roo_Entity {
    
    public static long RecordingLibraryService.countRecordingLibraryServices() {
        return (Long) entityManager().createQuery("select count(o) from RecordingLibraryService o").getSingleResult();
    }
    
    public static List<RecordingLibraryService> RecordingLibraryService.findAllRecordingLibraryServices() {
        return entityManager().createQuery("select o from RecordingLibraryService o").getResultList();
    }
    
    public static RecordingLibraryService RecordingLibraryService.findRecordingLibraryService(Long id) {
        if (id == null) return null;
        return entityManager().find(RecordingLibraryService.class, id);
    }
    
    public static List<RecordingLibraryService> RecordingLibraryService.findRecordingLibraryServiceEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from RecordingLibraryService o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
