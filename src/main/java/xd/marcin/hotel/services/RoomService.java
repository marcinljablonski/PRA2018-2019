package xd.marcin.hotel.services;

import xd.marcin.hotel.entities.Room;

public interface RoomService {

    Iterable<Room> listAllRooms();

    Room getRoomById(Integer id);

    Room saveRoom(Room room);

    void deleteRoom(Integer id);

}
