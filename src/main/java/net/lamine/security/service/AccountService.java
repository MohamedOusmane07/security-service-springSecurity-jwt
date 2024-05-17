package net.lamine.security.service;

import net.lamine.security.entities.AppRole;
import net.lamine.security.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser user);
    AppRole AddNewRole(AppRole role);
    void addRoleToUser(String username,String role);
    AppUser getUserByUsername(String username);
    List<AppUser> listUsers();

}
