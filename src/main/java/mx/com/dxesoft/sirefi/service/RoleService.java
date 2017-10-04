package mx.com.dxesoft.sirefi.service;

import mx.com.dxesoft.sirefi.entity.Role;

/**
 * sirefi-back, mx.com.dxesoft.sirefi.service . RoleService
 * Created by ernesto on 2/10/17.
 */
public interface RoleService {

    /**
     * Creates a Role.
     *
     * @param role Role to be created.
     * @return role created.
     */
    Role createRole(Role role);
}
