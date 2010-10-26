package com.callcenter.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;

import javax.persistence.*;
import java.util.List;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
@Entity
@Table(name = "users")
@RooJavaBean
@RooEntity(finders = { "findUsersByName" })
public class User {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private Locale language;

    @ManyToOne(optional = false, targetEntity = Role.class)
    @JoinColumn(nullable = false)
    private Role role;

    public static User findUserByName(final String name) {
        final List<User> users = findUsersByName(name).getResultList();
        if(users.isEmpty()) return null;

        return users.get(0);
    }

    public String getRoleName() {
        return role.getName();
    }
}
