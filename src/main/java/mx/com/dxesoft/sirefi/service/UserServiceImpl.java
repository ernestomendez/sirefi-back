package mx.com.dxesoft.sirefi.service;

import mx.com.dxesoft.sirefi.entity.Role;
import mx.com.dxesoft.sirefi.entity.User;
import mx.com.dxesoft.sirefi.repository.RoleRepository;
import mx.com.dxesoft.sirefi.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;

/**
 * sirefi-back, mx.com.dxesoft.sirefi.service . UserServiceImpl
 * Created by ernesto on 24/09/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        Assert.notNull(userName, "userName can not be null");

        return userRepository.findByUserName(userName);
    }

    @Override
    public User createUser(User user) {
        Assert.notNull(user, "User can not be null");
        log.debug("Request to create user: {}", user);

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepository.findByRoleName("ADMIN");
        user.setRoles(new HashSet<Role>(Collections.singletonList(userRole)));
        userRepository.save(user);

        return user;
    }
}
