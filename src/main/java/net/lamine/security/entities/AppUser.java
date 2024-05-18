package net.lamine.security.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String username;
    public String password;
    @ManyToMany(fetch = FetchType.EAGER)
    public Collection<AppRole> appRoles=new ArrayList<>(); //Des qu'on crée un user la liste est vide, pas null
}
