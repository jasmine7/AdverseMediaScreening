package lv.aml.adversemediascreening.core.builders.client;

import lv.aml.adversemediascreening.core.domain.Client;

public class ClientBuilder {

    private Long id;
    private String name;
    private String type;
    private String registrationNumber;
    private String country;

    private ClientBuilder(){

    }

    public static ClientBuilder createClient(){
        return new ClientBuilder();
    }

    public Client build(){
        Client client = new Client();
        client.setId(id);
        client.setName(name);
        client.setType(type);
        client.setRegistrationNumber(registrationNumber);
        client.setCountry(country);
        return client;
    }

    public ClientBuilder withId(Long id){
        this.id = id;
        return this;
    }

    public ClientBuilder withName(String name){
        this.name = name;
        return this;
    }

    public ClientBuilder withType(String type){
        this.type = type;
        return this;
    }

    public ClientBuilder withRegistrationNumber(String registrationNumber){
        this.registrationNumber = registrationNumber;
        return this;
    }

    public ClientBuilder withCountry(String country){
        this.country = country;
        return this;
    }
}
