package com.callcenter.domain;

import com.callcenter.domain.User;
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

privileged aspect User_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager User.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long User.id;
    
    @Version
    @Column(name = "version")
    private Integer User.version;
    
    public Long User.getId() {
        return this.id;
    }
    
    public void User.setId(Long id) {
        this.id = id;
    }
    
    public Integer User.getVersion() {
        return this.version;
    }
    
    public void User.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void User.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void User.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            User attached = this.entityManager.find(User.class, this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void User.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void User.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        User merged = this.entityManager.merge(this);
        this.entityManager.flush();
        this.id = merged.getId();
    }
    
    public static final EntityManager User.entityManager() {
        EntityManager em = new User().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long User.countUsers() {
        return (Long) entityManager().createQuery("select count(o) from User o").getSingleResult();
    }
    
    public static List<User> User.findAllUsers() {
        return entityManager().createQuery("select o from User o").getResultList();
    }
    
    public static User User.findUser(Long id) {
        if (id == null) return null;
        return entityManager().find(User.class, id);
    }
    
    public static List<User> User.findUserEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from User o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
