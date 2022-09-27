package com.example.Consultorio.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

import com.example.Consultorio.login.AppUserRoles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "User")
public class AppUser implements UserDetails{

    @Id
    @SequenceGenerator(name="user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Integer id;
    private String nome;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING) // indica que o Enum é do tipo String
    private AppUserRoles appUserRoles;

    public AppUser() {
    }

    public AppUser(String nome, String username, String email, String password, AppUserRoles appUserRoles) {
        this.nome = nome;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRoles = appUserRoles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUserRoles getAppUserRoles() {
        return appUserRoles;
    }

    public void setAppUserRoles(AppUserRoles appUserRoles) {
        this.appUserRoles = appUserRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // utilizar esse método para pegar algumas regras do nosso usuário que não vemos,
        // ou seja, são passadas no processamento da aplicação
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(appUserRoles.name());
        // serve para pegar as regras de cada usuário
        return Collections.singleton(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
