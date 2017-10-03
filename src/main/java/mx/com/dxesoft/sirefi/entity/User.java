package mx.com.dxesoft.sirefi.entity;

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
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sequenceGenerator") //esta es la estrategia de default no es necesario ponerla.
    @SequenceGenerator(name = "sequenceGenerator")
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
//    @JsonIgnore
//    @Transient
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

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public LocalDate getDisabledDate() {
        return disabledDate;
    }

    public void setDisabledDate(LocalDate disabledDate) {
        this.disabledDate = disabledDate;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
