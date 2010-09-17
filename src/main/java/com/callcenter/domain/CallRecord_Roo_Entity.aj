package com.callcenter.domain;

import com.callcenter.domain.CallRecord;
import java.lang.Integer;
import java.lang.Long;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Version;
import org.springframework.transaction.annotation.Transactional;

privileged aspect CallRecord_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager CallRecord.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long CallRecord.id;
    
    @Version
    @Column(name = "version")
    private Integer CallRecord.version;
    
    public Long CallRecord.getId() {
        return this.id;
    }
    
    public void CallRecord.setId(Long id) {
        this.id = id;
    }
    
    public Integer CallRecord.getVersion() {
        return this.version;
    }
    
    public void CallRecord.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void CallRecord.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void CallRecord.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            CallRecord attached = this.entityManager.find(CallRecord.class, this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void CallRecord.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void CallRecord.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        CallRecord merged = this.entityManager.merge(this);
        this.entityManager.flush();
        this.id = merged.getId();
    }
    
    public static final EntityManager CallRecord.entityManager() {
        EntityManager em = new CallRecord().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long CallRecord.countCallRecords() {
        return (Long) entityManager().createQuery("select count(o) from CallRecord o").getSingleResult();
    }
    
    public static List<CallRecord> CallRecord.findAllCallRecords() {
        return entityManager().createQuery("select o from CallRecord o").getResultList();
    }
    
    public static CallRecord CallRecord.findCallRecord(Long id) {
        if (id == null) return null;
        return entityManager().find(CallRecord.class, id);
    }
    
    public static List<CallRecord> CallRecord.findCallRecordEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from CallRecord o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
