package xd.marcin.hotel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xd.marcin.hotel.entities.*;
import xd.marcin.hotel.services.ClientService;
import xd.marcin.hotel.services.OccupationService;
import xd.marcin.hotel.services.ReservationService;
import xd.marcin.hotel.services.RoomService;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
@Component
public class CommandLiner implements CommandLineRunner {
  @Autowired
  ClientService clientService;

  @Autowired
  ReservationService reservationService;

  @Autowired
  RoomService roomService;

  @Autowired
  OccupationService occupationService;

  @Autowired
  Config config;

  @Override
  public void run(String ...args) throws Exception {
    System.out.println("Start");

//    Client client1 = new Client();
//    Address address1 = new Address();
//    Set<Reservation> resSet = new HashSet<>();
//    Set<Occupation> occSet = new HashSet<>();
//    Reservation reservation1 = new Reservation();
//    Occupation occupation1 = new Occupation();
//    Room room1 = new Room();
//    ZonedDateTime dateTime1 = ZonedDateTime.parse("2007-12-03T10:15:30+01:00[Europe/Paris]");
//    ZonedDateTime dateTime2 = ZonedDateTime.parse("2009-12-03T10:15:30+01:00[Europe/Paris]");
//    room1.setBeds(2);
//    room1.setComment("XD");
//    reservation1.setBeds(2);
//    reservation1.setComments("none");
//    reservation1.setFromDate(dateTime1);
//    reservation1.setToDate(dateTime2);
//    occupation1.setFromDate(dateTime1);
//    occupation1.setToDate(dateTime2);
//    resSet.add(reservation1);
//    occSet.add(occupation1);
//    address1.setCity("AAAA");
//    address1.setNr("2");
//    address1.setPostcode("1111-11");
//    client1.setAddress(address1);
//    client1.setEmail("a@b.c");
//    client1.setFirstName("OO");
//    client1.setLastName("LL");
//    client1.setPhone("11111111");
////    client1.setOccupations(occSet);
////    client1.setReservations(resSet);
//
//    occupation1.setRoom(room1);
//    reservation1.setClient(client1);
//    occupation1.setClient(client1);
//
//    clientService.saveClient(client1);
////    roomService.saveRoom(room1);
//    reservationService.saveReservation(reservation1);
//    occupationService.saveOccupation(occupation1);

    Iterable reservations = new LinkedList<>();
    Iterable occupations = new LinkedList<>();
    Iterable rooms = new LinkedList<>();
    Iterable clients = new LinkedList<>();
    clients = clientService.listAllClients();
    rooms = roomService.listAllRooms();
    reservations = reservationService.listAllReservations();
    occupations = occupationService.listAllOccupations();

    ObjectMapper mapper = config.getMapper();
    mapper.writeValue(new File("occupations.json"), occupations);


    //TODO w testach
    //Object to JSON in String
//    String jsonInString = mapper.writeValueAsString(obj);

  }

}
