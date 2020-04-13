package crow.teomant.gateway.user.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class UserDto {

    private Long id;

    private String email;

    private String username;

    private String password;

    private Integer active = 1;

    private boolean isLocked = false;

    private boolean isExpired = false;

    private boolean isEnabled = true;

    private Set<RoleDto> role = new HashSet<>();
}
