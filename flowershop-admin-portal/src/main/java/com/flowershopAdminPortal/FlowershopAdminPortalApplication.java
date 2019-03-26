package com.flowershopAdminPortal;

import com.flowershopAdminPortal.entity.Role;
import com.flowershopAdminPortal.entity.User;
import com.flowershopAdminPortal.entity.UserRole;
import com.flowershopAdminPortal.service.UserService;
import com.flowershopAdminPortal.utility.SecurityUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class FlowershopAdminPortalApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FlowershopAdminPortalApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User();
        user1.setFirstName("dan");
        user1.setLastName("byun");
        user1.setUsername("test");
        user1.setPassword(SecurityUtility.saltPasswordEncoder().encode("test123"));
        user1.setEmail("admin@gmail.com");
        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(1);
        role1.setName("ROLE_ADMIN");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1, userRoles);
    }
}

