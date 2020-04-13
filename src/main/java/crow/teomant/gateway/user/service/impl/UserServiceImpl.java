package crow.teomant.gateway.user.service.impl;

import crow.teomant.gateway.user.dto.RoleDto;
import crow.teomant.gateway.user.dto.UserDto;
import crow.teomant.gateway.user.entity.User;
import crow.teomant.gateway.user.repository.UserRepository;
import crow.teomant.gateway.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);

        return mapToDto(user);
    }

    private UserDto mapToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setActive(user.getActive());
        userDto.setEmail(user.getEmail());
        userDto.setEnabled(user.isEnabled());
        userDto.setExpired(user.isExpired());
        userDto.setId(user.getId());
        userDto.setLocked(user.isLocked());
        userDto.setPassword(user.getPassword());
        userDto.setUsername(user.getUsername());
        user.getRole().forEach(role -> {
                    RoleDto dto = new RoleDto();
                    dto.setId(role.getId());
                    dto.setRole(role.getRole());
                    userDto.getRole().add(dto);
                }
        );

        return userDto;
    }
}
