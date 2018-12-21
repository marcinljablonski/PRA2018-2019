package xd.marcin.hotel.repositories;

import org.springframework.data.repository.CrudRepository;
import xd.marcin.hotel.entities.Occupation;


public interface OccupationRepository extends CrudRepository<Occupation, Integer> {
}
