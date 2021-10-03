package lv.aml.adversemediascreening.core.builders.user;

import lv.aml.adversemediascreening.core.dto.UserDTO;

public class UserDTOBuilder {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;

    private UserDTOBuilder(){

    }

    public static UserDTOBuilder createUserDTO(){
        return new UserDTOBuilder();
    }

    public UserDTO build(){
        UserDTO user = new UserDTO();
        user.setId(id);
        user.setUsername(username);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;
    }

    public UserDTOBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public UserDTOBuilder withUsername(String username){
        this.username = username;
        return this;
    }

    public UserDTOBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public UserDTOBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }
}
