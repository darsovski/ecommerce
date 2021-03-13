package com.springboot.ecommerce.Service.impl;

import com.springboot.ecommerce.Service.UserService;
import com.springboot.ecommerce.model.User;
import com.springboot.ecommerce.model.dto.UserDto;
import com.springboot.ecommerce.model.exceptions.InvalidUsernameException;
import com.springboot.ecommerce.model.exceptions.UserAlreadyExistsException;
import com.springboot.ecommerce.model.exceptions.UserNotFoundException;
import com.springboot.ecommerce.model.exceptions.UsernameNotFoundException;
import com.springboot.ecommerce.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

   /* public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

   /* @Override
    public Optional<User> findByUserName(String  userName) {
        return this.userRepository.findByUsername(userName)
                .orElseThrow(() -> new UserNotFoundException(userName));
    }*/

    @Override
    public User registerUser(User user) {
        if (this.userRepository.existsById(user.getUsername())) {
            throw new UserAlreadyExistsException(user.getUsername());
        }
        return this.userRepository.save(user);
    }

    @Override
    public User findByUserName(String s)   {
        return this.userRepository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException(s));
    }

    @Override
    public User findById(Long userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public Optional<User> save(String firstName ,String lastName, String username, String email, String password, boolean isAdmin) {

        this.userRepository.deleteByUsername(username);
        return Optional.of(this.userRepository.save(new User(firstName,lastName,username,email,password,isAdmin)));
    }

    @Override
    public Optional<User> save(UserDto userDto) {

        this.userRepository.deleteByUsername(userDto.getUsername());
        return Optional.of(this.userRepository.save(new User(userDto.getFirstName(),userDto.getLastName(),userDto.getUsername(),userDto.getEmail(),
                userDto.getPassword(),userDto.isAdmin())));    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }


    public User registerUser(String firstName, String lastName, String username, String email, String password, boolean b) {
        if (this.userRepository.existsById(username)) {
            throw new UserAlreadyExistsException(username);
        }
        User user = new User(firstName,lastName,username,email,password,b);
        return this.userRepository.save(user);
    }

/*    @Override
    public UserDetails loadUserByUsername(String s) throws org.springframework.security.core.userdetails.UsernameNotFoundException {
        User user = this.userRepository.findByUsername(s).orElseThrow(InvalidUsernameException::new);
        UserDetails userDetails = new
                org.springframework.security.core.userdetails.
                        User(user.getUsername(),user.getPassword(),
                Stream.of(new SimpleGrantedAuthority(user.getRole().toString())).collect(Collectors.toList()));
        return userDetails;
    }*/
}
