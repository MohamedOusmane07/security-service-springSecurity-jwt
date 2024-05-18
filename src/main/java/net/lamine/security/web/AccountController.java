package net.lamine.security.web;

import net.lamine.security.entities.AppRole;
import net.lamine.security.entities.AppUser;
import net.lamine.security.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/user")
    public AppUser addUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }

    @PostMapping("/role")
    public AppRole addRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }

    @GetMapping("/user")
    public AppUser getUser(String username){
        return accountService.getUserByUsername(username);
    }




}
