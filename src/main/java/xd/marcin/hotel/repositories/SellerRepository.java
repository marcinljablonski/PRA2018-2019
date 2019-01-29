package xd.marcin.hotel.repositories;

import xd.marcin.hotel.entities.Product;
import xd.marcin.hotel.entities.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SellerRepository extends CrudRepository<Seller, Integer> {

    List<Seller> findByName(String name);

    @Query("select count(*) from Seller s join s.products p where s.id = ?1")
    Integer countProductsById(Integer id);

    @Query("select p from Seller s join s.productsOb p where s.id = ?1")
    List<Product> getProductsById(Integer id);
}
