package mx.com.dxesoft.sirefi.service;

import mx.com.dxesoft.sirefi.entity.Role;
import mx.com.dxesoft.sirefi.repository.RoleRepository;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * sirefi-back, mx.com.dxesoft.sirefi.service . RoleServiceImpl
 * Created by ernesto on 2/10/17.
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(Role role) {
        Validate.notNull(role, "Role can not be null");

        log.debug("Request to create a role");

        return roleRepository.save(role);
    }
}
