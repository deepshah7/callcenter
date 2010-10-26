package com.callcenter.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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

    @ManyToMany(targetEntity = Group.class, mappedBy = "members")
    private Set<Group> groups = new HashSet<Group>();

    public static User findUserByName(final String name) {
        final List<User> users = findUsersByName(name).getResultList();
        if(users.isEmpty()) return null;

        return users.get(0);
    }

    public String getRoleName() {
        return role.getName();
    }
}
