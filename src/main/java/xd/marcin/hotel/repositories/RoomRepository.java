package xd.marcin.hotel.repositories;

import org.springframework.data.repository.CrudRepository;
import xd.marcin.hotel.entities.Room;


public interface RoomRepository extends CrudRepository<Room, Integer> {
}
