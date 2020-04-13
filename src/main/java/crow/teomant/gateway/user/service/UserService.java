package crow.teomant.gateway.user.service;

import crow.teomant.gateway.user.dto.UserDto;

public interface UserService {

    UserDto getUserByUsername(String username);
}
