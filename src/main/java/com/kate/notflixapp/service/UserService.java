package com.kate.notflixapp.service;

import com.kate.notflixapp.repositories.Mysql.UserMRepository;
import com.kate.notflixapp.domainClasses.Mysql.MovieM;
import com.kate.notflixapp.domainClasses.Mysql.UserM;
import com.kate.notflixapp.domainClasses.Neo4j.UserN;

import com.kate.notflixapp.repositories.Mysql.RoleRepository;
import com.kate.notflixapp.repositories.Neo4j.UserNRepository;
import com.kate.notflixapp.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class UserService implements IUserService, UserDetailsService {
    Logger log = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserMRepository userMRepository;
    @Autowired
    private UserNRepository userNRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;




    @Override
    public UserN addUser(UserN u) {


        return userNRepository.save(u);
    }

    @Override
    public UserM addUser(UserM u) {
        u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
        u.setRoles(new HashSet<>(roleRepository.findAll()));

        return userMRepository.save(u);
    }


    @Override
    public void deleteUser(UserN m) {

    }

    @Override
    public void deleteUser(UserM u) {
        userMRepository.delete(u);

    }

    @Override
    public Iterable<UserM> getAllUsers() {
        return userMRepository.findAll();
    }

    @Override
    public Iterable<MovieM> getMoviesOfUser(Long id) {
        return userMRepository.getLikedMoviesByUserId(id);
    }

    @Override
    public UserM findByUsername(String s) {
        return userMRepository.findByUsername(s);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserM user = userMRepository.findByUsername(s);
        log.log(Level.INFO, "got to loadUserByUsername");
        log.log(Level.INFO, ""+user.getUsername());
        log.log(Level.INFO, ""+user.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        return new UserPrincipal(user);
    }
}
