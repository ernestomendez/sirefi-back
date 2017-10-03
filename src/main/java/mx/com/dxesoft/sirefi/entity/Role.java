package mx.com.dxesoft.sirefi.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * sirefi-back, mx.com.dxesoft.sirefi.entity . Role
 * Created by ernesto on 20/09/17.
 */
@Entity(name = "roles")
@Data
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_name")
    @NotNull
    private String roleName;


}
