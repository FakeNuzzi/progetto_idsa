package idsa.progetto_idsa.service.impl;

import idsa.progetto_idsa.dto.UserDto;
import idsa.progetto_idsa.entity.User;
import idsa.progetto_idsa.exception.ResourceNotFoundException;
import idsa.progetto_idsa.mapper.UserMapper;
import idsa.progetto_idsa.repository.UserRepository;
import idsa.progetto_idsa.service.UserService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id_user){
        User user = userRepository.findById(id_user)
            .orElseThrow(() -> new ResourceNotFoundException("User non esiste per un dato id : " + id_user));
            return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapToUserDto(user))
            .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long id_user, UserDto updatedUser){
        User user = userRepository.findById(id_user)
            .orElseThrow(() -> new ResourceNotFoundException("User non esiste per l'id dato : " + id_user));
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());
        user.setAttivo(updatedUser.getAttivo());
        user.setNome(updatedUser.getNome());
        user.setCognome(updatedUser.getCognome());
        user.setData_n(updatedUser.getData_n());
        user.setCf(updatedUser.getCf());
        User updatedUserObj = userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long id_user){
        userRepository.findById(id_user)
            .orElseThrow(() -> new ResourceNotFoundException("User non esiste per l'id dato : " + id_user));
        userRepository.deleteById(id_user);
    }
}
