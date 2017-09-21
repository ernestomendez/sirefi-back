package mx.com.dxesoft.sirefi.repository;

import mx.com.dxesoft.sirefi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * sirefi-back, mx.com.dxesoft.sirefi.repository . UserRepository
 * Created by ernesto on 20/09/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String email);
}
