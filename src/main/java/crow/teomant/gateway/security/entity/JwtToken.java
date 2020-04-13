package crow.teomant.gateway.security.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "tokens")
@AllArgsConstructor
@NoArgsConstructor
public class JwtToken {

    @Id
    @Column(name = "token")
    String token;
}
