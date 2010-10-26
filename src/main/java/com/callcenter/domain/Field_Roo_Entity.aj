package com.callcenter.domain;

import com.callcenter.domain.Field;
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

privileged aspect Field_Roo_Entity {
    
    @PersistenceContext
    transient EntityManager Field.entityManager;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Field.id;
    
    @Version
    @Column(name = "version")
    private Integer Field.version;
    
    public Long Field.getId() {
        return this.id;
    }
    
    public void Field.setId(Long id) {
        this.id = id;
    }
    
    public Integer Field.getVersion() {
        return this.version;
    }
    
    public void Field.setVersion(Integer version) {
        this.version = version;
    }
    
    @Transactional
    public void Field.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Field.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Field attached = this.entityManager.find(Field.class, this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Field.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Field.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Field merged = this.entityManager.merge(this);
        this.entityManager.flush();
        this.id = merged.getId();
    }
    
    public static final EntityManager Field.entityManager() {
        EntityManager em = new Field().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Field.countFields() {
        return (Long) entityManager().createQuery("select count(o) from Field o").getSingleResult();
    }
    
    public static List<Field> Field.findAllFields() {
        return entityManager().createQuery("select o from Field o").getResultList();
    }
    
    public static Field Field.findField(Long id) {
        if (id == null) return null;
        return entityManager().find(Field.class, id);
    }
    
    public static List<Field> Field.findFieldEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("select o from Field o").setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
}
