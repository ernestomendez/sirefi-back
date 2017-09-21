package mx.com.dxesoft.sirefi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * sirefi-back, mx.com.dxesoft.sirefi.entity . User
 * Created by ernesto on 17/09/17.
 */
@Entity(name = "user")
@Getter
@Setter
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //esta es la estrategia de default no es necesario ponerla.
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull
    /*
     * La diferencia entre nullable=false y @NotNull es que el nullable esta ligado a la base de datos es decir es un constraint de la base de datos
     * cuando hibernate crea esa tabla la crea con el constraint not null.
     * En cambio @NotNull es parte de la especificacion JSR 303 Bean Validation {http://download.oracle.com/otndocs/jcp/bean_validation-1.0-fr-oth-JSpec/}
     * la cual verifica que el atributo no permita valores nulos, es decir en la creacion del objeto siempre debe tener un valor.
     *
     * Algunos JPA Providers como hibernate convierten el @NotNull en nullable = true, pero no todos. Para este caso en especifico, al no estar construyendo
     * la base de datos con hibernate, no es necesario poner los dos.
     *
     */
    private String userName;

    @Column
    @NotNull
    @JsonIgnore
    @Transient
    private String password;   //TODO Convertir esto a char

    @Column
    @NotNull
    private String name;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column
    private boolean enabled;

    @Column(name = "disabled_date")
    private LocalDate disabledDate;

    /*
    Al cambiar el foreing key en la tabla, olvidé cambiar el JoinColumn.
     */
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "rol_id", referencedColumnName = "id")}
    )
    private Set<Rol> roles = new HashSet<>();
}
