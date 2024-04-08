//package com.example.sportevents.rest.securityconfig;
//
//import com.example.sportevents.persistence.entities.Admin;
//import com.example.sportevents.persistence.repository.AdminRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    private final AdminRepository adminRepository;
//
//    public UserDetailsServiceImpl(AdminRepository adminRepository) {
//        this.adminRepository = adminRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Admin admin = adminRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Not found"));
//        return new UserDetailsImpl(admin);
//    }
//}
