package xd.marcin.hotel.services;

import xd.marcin.hotel.entities.Reservation;

import java.util.List;

public interface ReservationService {

    Iterable<Reservation> listAllReservations();

    Reservation getReservationById(Integer id);

    Reservation saveReservation(Reservation reservation);

    void saveManyReservations(Iterable<Reservation> reservations);

    void deleteReservation(Integer id);

    List<Reservation> getByLastName(String lastName);

    Boolean checkIfExist(Integer id);

    Iterable<Reservation> listAllReservationsPaging(Integer pageNr, Integer howManyOnPage);
}
