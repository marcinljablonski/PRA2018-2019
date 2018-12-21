package xd.marcin.hotel.repositories;

import org.springframework.data.repository.CrudRepository;
import xd.marcin.hotel.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
