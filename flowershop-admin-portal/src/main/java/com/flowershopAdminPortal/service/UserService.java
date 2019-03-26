package com.flowershopAdminPortal.service;

import com.flowershopAdminPortal.entity.User;
import com.flowershopAdminPortal.entity.UserRole;

import java.util.Set;

public interface UserService {

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);
}
