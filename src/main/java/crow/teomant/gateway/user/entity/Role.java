package crow.teomant.gateway.user.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Table(name = "roles")
@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, insertable = false)
    private Long id;

    @Column(name = "role", nullable = false)
    private String role;

    @ManyToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();
}
