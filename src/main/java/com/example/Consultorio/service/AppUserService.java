package com.example.Consultorio.service;

import com.example.Consultorio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // busca por e-mail e caso aconteça algum erro, ele instancia uma mensagem indicando o erro
        return userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Usuário não encontrado"));

    }
}
