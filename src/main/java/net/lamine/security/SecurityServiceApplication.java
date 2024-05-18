package net.lamine.security;

import net.lamine.security.entities.AppRole;
import net.lamine.security.entities.AppUser;
import net.lamine.security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SecurityServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addNewRole(new AppRole(null, "USER"));
            accountService.addNewRole(new AppRole(null, "ADMIN"));
            accountService.addNewRole(new AppRole(null, "MANAGER"));
            accountService.addNewRole(new AppRole(null, "CUSTOMER-MANAGER"));
            accountService.addNewRole(new AppRole(null, "PRODUCT-MANAGER"));


            accountService.addNewUser(new AppUser(null,"user1","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user2","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user4","12345",new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"user3","12345",new ArrayList<>()));

            accountService.addRoleToUser("user1","USER");
            accountService.addRoleToUser("user2","CUSTOMER-MANAGER");
            accountService.addRoleToUser("user","ADMIN");
            accountService.addRoleToUser("user","USER");
            accountService.addRoleToUser("user","CUSTOMER-MANAGER");
            accountService.addRoleToUser("user1","PRODUCT-MANAGER");



            accountService.addRoleToUser("user3","PRODUCT-MANAGER");
            accountService.addRoleToUser("user4","MANAGER");





        };
    }

}
