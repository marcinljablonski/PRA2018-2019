package xd.marcin.hotel.services;

import xd.marcin.hotel.entities.Client;

public interface ClientService {

//    Iterable<Client> listAllClients();

//    Product getProductById(Integer id);

    Client saveClient(Client client);

//    void deleteProduct(Integer id);

    Boolean checkIfExist(Integer id);

    public Iterable<Client> listAllClientsPaging(Integer pageNr, Integer howManyOnPage);

}
