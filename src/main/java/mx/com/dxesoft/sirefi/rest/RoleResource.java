package mx.com.dxesoft.sirefi.rest;

import mx.com.dxesoft.sirefi.entity.Role;
import mx.com.dxesoft.sirefi.service.RoleService;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * sirefi-back, mx.com.dxesoft.sirefi.rest . RoleResource
 * Created by ernesto on 2/10/17.
 */
@RestController
@RequestMapping("/api")
public class RoleResource {

    private final Logger log = LoggerFactory.getLogger(RoleResource.class);

    private final RoleService roleService;

    @Autowired
    public RoleResource(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/role")
    @Secured("ADMIN")
    public void createRole(@RequestBody Role role) {
        log.debug("Request to create a role");
        Validate.notNull(role, "Role can not be null");

        roleService.createRole(role);
    }

}
