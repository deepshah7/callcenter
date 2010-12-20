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

import com.callcenter.domain.Collection;
import com.callcenter.domain.User;
import mockit.*;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertSame;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class CallcenterUserDetalisServiceTest {

    @Test
    public void shouldLoadUserByUserName(final @NonStrict User user,
                                         final @NonStrict GrantedAuthorityImpl authority) {
        final ArrayList<String> authorities = new ArrayList<String>();
        authorities.add("Role1");
        authorities.add("Role2");
        new NonStrictExpectations() {{
            User.findUserByName("HelloUser"); returns(user);
            user.getAuthorities(); returns(authorities);
            new GrantedAuthorityImpl("Role1");
            new GrantedAuthorityImpl("Role2");
            user.getName(); returns("User1");
            user.getPassword(); returns("password1");
        }};

        final UserDetails foundUser = new CallcenterUserDetailsService().loadUserByUsername("HelloUser");
        assertNotNull(foundUser);
        assertEquals("User1", foundUser.getUsername());
        assertEquals("password1", foundUser.getPassword());
        assertEquals(2, foundUser.getAuthorities().size());
    }

}