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
package com.callcenter;

import com.callcenter.builder.UserBuilder;
import com.callcenter.domain.Role;
import com.callcenter.domain.User;
import com.callcenter.service.CallcenterUserDetailsService;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class CallcenterUserDetailsServiceTest {

    private CallcenterUserDetailsService service;

    @Before
    public void setUp() {
        service = new CallcenterUserDetailsService();
    }

    @Test
    public void shouldLoadTheUserByTheGivenUserName() {

        new NonStrictExpectations() {
            @Mocked User user;
            {
                user.getRoleName(); returns("ADMIN");
                user.getName(); returns("Hello");
                user.getPassword(); returns("World");
                User.findUserByName("Hello"); returns(user);
            }
        };

        final UserDetails userDetails = service.loadUserByUsername("Hello");
        assertNotNull(userDetails);
        assertEquals("Hello", userDetails.getUsername());
        assertEquals("ADMIN", userDetails.getAuthorities().iterator().next().getAuthority());
    }
}
