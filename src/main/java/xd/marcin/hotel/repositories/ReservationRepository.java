package xd.marcin.hotel.repositories;

import xd.marcin.hotel.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    List<Reservation> findById(Integer id);

//    @Query("select count(*) from client c join c.products p where s.id = ?1")
//    Integer countProductsById(Integer id);

    @Query("select p from Seller s join s.productsOb p where s.id = ?1")
    List<Product> getProductsById(Integer id);
}
