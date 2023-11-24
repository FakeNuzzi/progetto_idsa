package idsa.progetto_idsa.service;

import java.util.List;

import idsa.progetto_idsa.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id_user);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long id_user, UserDto updatedPaziente);
    void deleteUser(Long id_user);
}
