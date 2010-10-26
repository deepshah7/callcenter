package com.callcenter.domain;

import com.callcenter.domain.Group;
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

privileged aspect Group_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Group.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Group.id;
    
    @Version
    @Column(name = "version")
    private Integer Group.version;
    
    public Long Group.getId() {
        return this.id;
    }
    
    public void Group.setId(Long id) {
        this.id = id;
    }
    
    public Integer Group.getVersion() {
        return this.version;
    }
    
    public void Group.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Group.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Group.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Group attached = this.entityManager.find(Group.class, this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Group.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Group.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Group merged = this.entityManager.merge(this);
        this.entityManager.flush();
        this.id = merged.getId();
    }
    
    public static final EntityManager Group.entityManager() {
        EntityManager em = new Group().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Group.countGroups() {
        return (Long) entityManager().createQuery("select count(o) from Group o").getSingleResult();
    }
    
    public static List<Group> Group.findAllGroups() {
        return entityManager().createQuery("select o from Group o").getResultList();
    }
    
    public static Group Group.findGroup(Long id) {
        if (id == null) return null;
        return entityManager().find(Group.class, id);
    }
    
    public static List<Group> Group.findGroupEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Group o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
