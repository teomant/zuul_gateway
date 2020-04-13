package crow.teomant.gateway.user.service.impl;

import crow.teomant.gateway.exception.CustomException;
import crow.teomant.gateway.user.dto.RoleDto;
import crow.teomant.gateway.user.dto.UserDto;
import crow.teomant.gateway.user.entity.CustomUserDetails;
import crow.teomant.gateway.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto user = userService.getUserByUsername(username);
        if (user == null || user.getRole() == null || user.getRole().isEmpty()) {
            throw new CustomException("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
        String[] authorities = new String[user.getRole().size()];
        int count = 0;
        for (RoleDto role : user.getRole()) {
            authorities[count] = "ROLE_" + role.getRole();
            count++;
        }

        return new CustomUserDetails(user.getEmail(), user.getPassword(), user.getActive(),
                user.isLocked(), user.isExpired(), user.isEnabled(), authorities);
    }
}
