package lv.aml.adversemediascreening.core.converters;

import lv.aml.adversemediascreening.core.domain.Client;
import lv.aml.adversemediascreening.core.dto.ClientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.aml.adversemediascreening.core.builders.client.ClientBuilder.*;
import static lv.aml.adversemediascreening.core.builders.client.ClientDTOBuilder.*;

@Component
public class ClientConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientConverter.class);

    public Client convertToEntity(ClientDTO clientDTO){
        if(clientDTO == null){
            return null;
        } else {
            return createClient()
                    .withId(clientDTO.getId())
                    .withName(clientDTO.getName())
                    .withType(clientDTO.getType())
                    .withRegistrationNumber(clientDTO.getRegistrationNumber())
                    .withCountry(clientDTO.getCountry())
                    .build();
        }
    }

    public ClientDTO convertToDTO(Client client){
        if(client == null){
            return null;
        } else {
            return createClientDTO()
                    .withId(client.getId())
                    .withName(client.getName())
                    .withType(client.getType())
                    .withRegistrationNumber(client.getRegistrationNumber())
                    .withCountry(client.getCountry())
                    .build();
        }
    }

    public List<Client> convertToEntity(List<ClientDTO> clientDTOs){
        if(clientDTOs != null){
            List<Client> clients = new ArrayList<>();
            if(!clientDTOs.isEmpty()){
                for(ClientDTO clientDTO: clientDTOs){
                    clients.add(convertToEntity(clientDTO));
                }
            }
            return clients;
        }
        return null;
    }

    public List<ClientDTO> convertToDTO(List<Client> clients){
        if(clients != null){
            List<ClientDTO> clientDTOs = new ArrayList<>();
            if(!clients.isEmpty()){
                for (Client client: clients){
                    clientDTOs.add(convertToDTO(client));
                }
            }
            return clientDTOs;
        }
        return null;
    }
}
