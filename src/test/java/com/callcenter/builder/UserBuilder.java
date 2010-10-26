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
package com.callcenter.builder;

import com.callcenter.domain.Role;
import com.callcenter.domain.User;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Deep Shah
 */
public class UserBuilder {
    private String name;
    private String roleName;

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder withRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public User build() {
        final User user = new User();
        user.setName(name);
        final Role role = new Role();
        role.setName(roleName);
        user.setRole(role);
        return user;
    }
}
