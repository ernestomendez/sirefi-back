package mx.com.dxesoft.sirefi.repository;

import mx.com.dxesoft.sirefi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * sirefi-back, mx.com.dxesoft.sirefi.repository . RoleRepository
 * Created by ernesto on 20/09/17.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(String rolName);

}
