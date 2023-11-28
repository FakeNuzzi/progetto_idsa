package idsa.progetto_idsa.mapper;

import idsa.progetto_idsa.entity.User;
import idsa.progetto_idsa.dto.UserDto;

public class UserMapper{
    public static UserDto mapToUserDto(User user){
        return new UserDto(
            user.getId_utente(),
            user.getUsername(),
            user.getPassword(),
            user.getRoles(),
            user.getAttivo(),
            user.getNome(),
            user.getCognome(),
            user.getData_n(),
            user.getCf()
        );
    }
    
    public static User mapToUser(UserDto userDto){
        return new User(
            userDto.getId_utente(),
            userDto.getUsername(),
            userDto.getPassword(),
            userDto.getRoles(),
            userDto.getAttivo(),
            userDto.getNome(),
            userDto.getCognome(),
            userDto.getData_n(),
            userDto.getCf()
        );
    }
}
