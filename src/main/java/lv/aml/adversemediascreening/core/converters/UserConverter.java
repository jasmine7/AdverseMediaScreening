package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.core.domain.User;
import lv.aml.adversemediascreening.core.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.aml.adversemediascreening.core.builders.user.UserDTOBuilder.*;
import static lv.aml.adversemediascreening.core.builders.user.UserBuilder.*;

@Component
public class UserConverter {

    public User convertToEntity(UserDTO userDTO){
        if(userDTO == null){
            return null;
        } else {
            return createUser()
                    .withId(userDTO.getId())
                    .withUsername(userDTO.getUsername())
                    .withFirstName(userDTO.getFirstName())
                    .withLastName(userDTO.getLastName())
                    .build();
        }
    }

    public UserDTO convertToDTO(User user){
        if(user == null){
            return null;
        } else {
            return createUserDTO()
                    .withId(user.getId())
                    .withUsername(user.getUsername())
                    .withFirstName(user.getFirstName())
                    .withLastName(user.getLastName())
                    .build();
        }
    }

    public List<User> convertToEntity(List<UserDTO> userDTOs){
        if(userDTOs != null){
            List<User> users = new ArrayList<>();
            if(!userDTOs.isEmpty()){
                for (UserDTO userDTO: userDTOs){
                    users.add(convertToEntity(userDTO));
                }
            }
            return users;
        }
        return null;
    }

    public List<UserDTO> convertToDTO(List<User> users){
        if(users != null){
            List<UserDTO> userDTOs = new ArrayList<>();
            if(!users.isEmpty()){
                for (User user: users){
                    userDTOs.add(convertToDTO(user));
                }
                return userDTOs;
            }
        }
        return null;
    }
}
