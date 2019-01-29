package xd.marcin.hotel.services;

import xd.marcin.hotel.entities.Seller;

import java.util.List;

public interface SellerService {

    Iterable<Seller> listAllSellers();

    Seller getSellerById(Integer id);

    Seller saveSeller(Seller seller);

    void deleteSeller(Integer id);

    List<Seller> getByName(String name);

    Integer getNumberOfProducts(Integer id);

    Seller getBestSeller();
}
