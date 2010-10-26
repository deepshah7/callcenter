package com.callcenter.domain;

import java.lang.String;
import java.lang.SuppressWarnings;
import javax.persistence.EntityManager;
import javax.persistence.Query;

privileged aspect User_Roo_Finder {
    
    @SuppressWarnings("unchecked")
    public static Query User.findUsersByName(String name) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
        EntityManager em = User.entityManager();
        Query q = em.createQuery("SELECT User FROM User AS user WHERE user.name = :name");
        q.setParameter("name", name);
        return q;
    }
    
}
