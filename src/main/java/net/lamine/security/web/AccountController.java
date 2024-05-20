package net.lamine.security.web;

import lombok.Data;
import net.lamine.security.entities.AppRole;
import net.lamine.security.entities.AppUser;
import net.lamine.security.service.AccountService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/users")
    public List<AppUser> getUsers(){
        return accountService.listUsers();
    }


    @PostMapping("/user")
    public AppUser addUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }

    @PostMapping("/role")
    public AppRole addRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }

    @GetMapping("/user/{username}")
    public AppUser getUser(@PathVariable String username) {
        return accountService.getUserByUsername(username);
    }


    @PostMapping("/addRoleToUser")
    public void roleToUser(@RequestBody String username,String role){
        accountService.addRoleToUser(username,role);

    }

}

@Data
class RoletoUser {
    private String username;
    private String role;
}

