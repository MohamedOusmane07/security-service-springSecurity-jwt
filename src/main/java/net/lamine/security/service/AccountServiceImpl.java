package net.lamine.security.service;

import net.lamine.security.entities.AppRole;
import net.lamine.security.entities.AppUser;
import net.lamine.security.repositories.AppRoleRepository;
import net.lamine.security.repositories.AppUserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    AppUserRepository userRepository;
    AppRoleRepository roleRepository;

    public AccountServiceImpl(AppUserRepository userRepository, AppRoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public AppUser addNewUser(AppUser user) {

        return userRepository.save(user);
    }

    @Override
    public AppRole AddNewRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser user = userRepository.findByUsername(username);
        if(user != null) {
            AppRole role=roleRepository.findByRoleName(roleName);
            if(role != null) {
                user.getAppRoles().add(role);
            }
            else {
                System.out.println("Role not found");
            }
        }
        else {
            System.out.println("User not found");
        }

    }

    @Override
    public AppUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        return userRepository.findAll();
    }
}
