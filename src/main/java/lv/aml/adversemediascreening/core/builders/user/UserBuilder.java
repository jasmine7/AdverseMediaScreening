package lv.aml.adversemediascreening.core.builders.user;

import lv.aml.adversemediascreening.core.domain.User;

public class UserBuilder {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    private UserBuilder(){

    }

    public static UserBuilder createUser(){
        return new UserBuilder();
    }

    public User build(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;
    }

    public UserBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public UserBuilder withUsername(String username){
        this.username = username;
        return this;
    }

    public UserBuilder withPassword(String password){
        this.password = password;
        return this;
    }

    public UserBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }
}
