package lv.aml.adversemediascreening.core.exceptions;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id){
        super("Client with id " + id.toString() + " not found");
    }

    public ClientNotFoundException(String name){
        super("Client with name " + name + " not found");
    }
}
