package com.callcenter.domain;

import com.callcenter.domain.Service;
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

privileged aspect Service_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Service.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Service.id;
    
    @Version
    @Column(name = "version")
    private Integer Service.version;
    
    public Long Service.getId() {
        return this.id;
    }
    
    public void Service.setId(Long id) {
        this.id = id;
    }
    
    public Integer Service.getVersion() {
        return this.version;
    }
    
    public void Service.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Service.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Service.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Service attached = this.entityManager.find(Service.class, this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Service.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Service.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Service merged = this.entityManager.merge(this);
        this.entityManager.flush();
        this.id = merged.getId();
    }
    
    public static final EntityManager Service.entityManager() {
        EntityManager em = new Service(){
        }.entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Service.countServices() {
        return (Long) entityManager().createQuery("select count(o) from Service o").getSingleResult();
    }
    
    public static List<Service> Service.findAllServices() {
        return entityManager().createQuery("select o from Service o").getResultList();
    }
    
    public static Service Service.findService(Long id) {
        if (id == null) return null;
        return entityManager().find(Service.class, id);
    }
    
    public static List<Service> Service.findServiceEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Service o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
