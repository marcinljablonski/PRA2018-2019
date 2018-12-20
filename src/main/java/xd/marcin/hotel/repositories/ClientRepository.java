package xd.marcin.hotel.repositories;

import xd.marcin.hotel.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends CrudRepository<Client, Integer>, PagingAndSortingRepository<Client, Integer> {

    Client findById(String clientId);

    @Query("select count(*) from client c where c.id = ?1")
    Integer checkIfExist(Integer id);
}
