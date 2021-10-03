package lv.aml.adversemediascreening.core.builders.client;

import lv.aml.adversemediascreening.core.dto.ClientDTO;

public class ClientDTOBuilder {

    private Long id;
    private String name;
    private String type;
    private String registrationNumber;
    private String country;

    private ClientDTOBuilder(){

    }

    public static ClientDTOBuilder createClientDTO(){
        return new ClientDTOBuilder();
    }

    public ClientDTO build(){
        ClientDTO client = new ClientDTO();
        client.setId(id);
        client.setName(name);
        client.setType(type);
        client.setRegistrationNumber(registrationNumber);
        client.setCountry(country);
        return client;
    }

    public ClientDTOBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public ClientDTOBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ClientDTOBuilder withType(String type){
        this.type = type;
        return this;
    }

    public ClientDTOBuilder withRegistrationNumber(String registrationNumber){
        this.registrationNumber = registrationNumber;
        return this;
    }

    public ClientDTOBuilder withCountry(String country){
        this.country = country;
        return this;
    }
}
