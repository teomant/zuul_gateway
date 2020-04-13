package crow.teomant.gateway.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Table(name = "users")
@Entity
@Getter
@Setter
@ToString(exclude = "password")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;

    @Email(message = "*Please provide a valid email")
    @Column(name = "Email", nullable = false)
    private String email;

    @NotEmpty(message = "*Please provide your name")
    @Column(name = "username", nullable = false)
    private String username;

    @NotEmpty(message = "*Please provide your password")
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active")
    private Integer active = 1;

    @Column(name = "locked")
    private boolean isLocked = false;

    @Column(name = "expired")
    private boolean isExpired = false;

    @Column(name = "enabled")
    private boolean isEnabled = true;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_role",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") }
    )
    private Set<Role> role;

}
