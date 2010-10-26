package com.callcenter.domain;

import com.callcenter.domain.Restriction;
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

privileged aspect Restriction_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Restriction.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Restriction.id;
    
    @Version
    @Column(name = "version")
    private Integer Restriction.version;
    
    public Long Restriction.getId() {
        return this.id;
    }
    
    public void Restriction.setId(Long id) {
        this.id = id;
    }
    
    public Integer Restriction.getVersion() {
        return this.version;
    }
    
    public void Restriction.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Restriction.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Restriction.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Restriction attached = this.entityManager.find(Restriction.class, this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Restriction.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Restriction.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Restriction merged = this.entityManager.merge(this);
        this.entityManager.flush();
        this.id = merged.getId();
    }
    
    public static final EntityManager Restriction.entityManager() {
        EntityManager em = new Restriction().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Restriction.countRestrictions() {
        return (Long) entityManager().createQuery("select count(o) from Restriction o").getSingleResult();
    }
    
    public static List<Restriction> Restriction.findAllRestrictions() {
        return entityManager().createQuery("select o from Restriction o").getResultList();
    }
    
    public static Restriction Restriction.findRestriction(Long id) {
        if (id == null) return null;
        return entityManager().find(Restriction.class, id);
    }
    
    public static List<Restriction> Restriction.findRestrictionEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Restriction o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
