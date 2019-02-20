package xd.marcin.hotel.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import xd.marcin.hotel.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Integer>, PagingAndSortingRepository<Reservation, Integer> {

    List<Reservation> findById(Integer id);

    @Query("select r from Reservation r join r.client c where c.lastName = ?1")
    List<Reservation> findsByLastName(String lastName);

    @Query("select count(*) from Client c where c.id = ?1")
    Integer checkIfExist(Integer id);
}
