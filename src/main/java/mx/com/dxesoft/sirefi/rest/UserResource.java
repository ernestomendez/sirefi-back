package mx.com.dxesoft.sirefi.rest;

import mx.com.dxesoft.sirefi.entity.User;
import mx.com.dxesoft.sirefi.service.UserService;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

/**
 * sirefi-back, mx.com.dxesoft.sirefi.rest . UserResource
 * Created by ernesto on 1/10/17.
 */
@RestController
@RequestMapping("/api")
public class UserResource {

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

    private final UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    @Secured("ADMIN")
    public void createUser(@RequestBody User user) throws URISyntaxException {
        log.debug("Creating user");

        userService.createUser(user);
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        Validate.notBlank(userName, "User name can not be null");
        log.debug("Request to find a user by user name: {userName}", userName);

        Optional<User> userOptional = userService.findByUserName(userName);

        return userOptional.map(response -> ResponseEntity.ok().headers(null).body(response))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
}
