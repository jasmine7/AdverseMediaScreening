package lv.aml.adversemediascreening.core.services.client;

import lv.aml.adversemediascreening.core.domain.Client;

public interface ClientFactory {

    Client create(String name,
                  String type,
                  String registrationNumber,
                  String country);
}
