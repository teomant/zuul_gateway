package crow.teomant.gateway.user.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {
    private String username;
    private String password;
    private Integer active;
    private boolean isLocked;
    private boolean isExpired;
    private boolean isEnabled;
    private List<GrantedAuthority> grantedAuthorities;

    public CustomUserDetails(String username, String password, Integer active, boolean isLocked, boolean isExpired, boolean isEnabled, String[] authorities) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.isLocked = isLocked;
        this.isExpired = isExpired;
        this.isEnabled = isEnabled;
        this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
    }

    public CustomUserDetails(String username, String[] authorities) {
        this.username = username;
        this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
    }

    public CustomUserDetails() {
        super();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isExpired;
    }
}
