package mx.com.dxesoft.sirefi.service;

import mx.com.dxesoft.sirefi.entity.User;

import java.util.Optional;

/**
 * sirefi-back, mx.com.dxesoft.sirefi.service . UserService
 * Created by ernesto on 23/09/17.
 */
public interface UserService {

    /**
     * finds a specific user from it's user name.
     *
     * @param userName userName to find.
     * @return foud user.
     */
    Optional<User> findByUserName(String userName);

    /**
     * Saves a user.
     *
     * @param user user to be saved.
     * @return the user saved.
     */
    User createUser(User user);
}
