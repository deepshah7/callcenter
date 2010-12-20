/*
 * Copyright 2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.callcenter.service;

import com.callcenter.domain.Field;
import com.callcenter.domain.RecordingLibraryService;
import com.callcenter.domain.Role;
import com.callcenter.domain.Services;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The service that will be used to get the user details.
 *
 * @author Deep Shah
 */
@Service(value = "callcenterUserDetailsService")
@Transactional
public class UserService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException, DataAccessException {
        final com.callcenter.domain.User user = com.callcenter.domain.User.findUserByName(userName);
        if(user == null) throw new UsernameNotFoundException("User with the name: " + userName + " was not found");

        final ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

        for(final String authorityName : user.getAuthorities()) {
            grantedAuthorities.add(new GrantedAuthorityImpl(authorityName));
        }
        return new User(user.getName(), user.getPassword(),
                true, true, true, true, grantedAuthorities);
    }

    public Role getCurrentUserRole() {
        return findCurrentUserRole();
    }

    public List<com.callcenter.domain.User> getUsersForCurrentRole() {
        final Role currentUserRole = findCurrentUserRole();
        return com.callcenter.domain.User.findUsersByRoles(currentUserRole.getAssignableRoles());
    }

    public void addAssignableRoleToCurrentUser(Role role) {
        final Role currentUserRole = findCurrentUserRole();
        currentUserRole.addToAssignableRoles(role);
        currentUserRole.persist();
    }

    public List<Field> getAvailableFieldsForCurrentUser() {
        final Role currentUserRole = findCurrentUserRole();
        final RecordingLibraryService recordingLibraryService
                = new Services(currentUserRole.getServices()).getRecordingLibraryService();
        if(recordingLibraryService == null) return new ArrayList<Field>();
        return new ArrayList<Field>(recordingLibraryService.getAvailableFields());
    }

    private Role findCurrentUserRole() {
        final Collection<GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        final List<String> roleNames = new ArrayList<String>();
        for(final GrantedAuthority grantedAuthority : authorities) {
            roleNames.add(grantedAuthority.getAuthority());
        }
        return Role.findRoleByNameIn(roleNames);
    }
}
