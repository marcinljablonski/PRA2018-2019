package xd.marcin.hotel.services;

import xd.marcin.hotel.entities.Address;

public interface AddressService {

    Iterable<Address> listAllAddresses();

    Address getAddressById(Integer id);

    Address saveAddress(Address address);

    void deleteAddress(Integer id);

}
