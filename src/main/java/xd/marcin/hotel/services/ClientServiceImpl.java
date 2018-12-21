package xd.marcin.hotel.services;

import xd.marcin.hotel.entities.Client;
import xd.marcin.hotel.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Client service implement.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Iterable<Client> listAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Iterable<Client> listAllClientsPaging(Integer pageNr, Integer howManyOnPage) {
        return clientRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Client getClientById(Integer id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (clientRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }


}
