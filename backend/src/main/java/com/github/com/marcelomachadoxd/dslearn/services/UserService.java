package com.github.com.marcelomachadoxd.dslearn.services;

import com.github.com.marcelomachadoxd.dslearn.DTO.UserDTO;
import com.github.com.marcelomachadoxd.dslearn.entities.User;
import com.github.com.marcelomachadoxd.dslearn.entities.repositories.UserRepository;
import com.github.com.marcelomachadoxd.dslearn.services.exceptions.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;


    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        try {
            Optional<User> obj = userRepository.findById(id);
            User user = obj.orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));

            return new UserDTO(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Not found id: " + id);

        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(s);
        if (user == null) {
            logger.error("user not found " + s);
            throw new UsernameNotFoundException("Email não encontrado");
        }
        logger.info("User found " + s);
        return user;
    }

}
