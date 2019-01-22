package xd.marcin.hotel.services;

import org.springframework.stereotype.Service;
import xd.marcin.hotel.entities.Address;

public interface AddressService {

    Iterable<Address> listAllAddresses();

    Address getAddressById(Integer id);

    Address saveAddress(Address address);

    void deleteAddress(Integer id);

}
