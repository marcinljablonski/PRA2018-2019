package xd.marcin.hotel.services;

import xd.marcin.hotel.entities.Client;

public interface ClientService {

    Iterable<Client> listAllClients();

    Client getClientById(Integer id);

    Client saveClient(Client client);

    void deleteClient(Integer id);

    Boolean checkIfExist(Integer id);

    Iterable<Client> listAllClientsPaging(Integer pageNr, Integer howManyOnPage);

}
