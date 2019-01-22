package xd.marcin.hotel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.core.type.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xd.marcin.hotel.entities.*;
import xd.marcin.hotel.services.*;

import java.io.File;
import java.util.*;

@Slf4j
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
  AddressService addressService;

  @Autowired
  Config config;

  @Override
  public void run(String ...args) throws Exception {
//    System.out.println("Start");
//
//    Client client1 = new Client();
//    Address address1 = new Address();
//    Set<Reservation> resSet = new HashSet<>();
//    Set<Occupation> occSet = new HashSet<>();
//    Reservation reservation1 = new Reservation();
//    Occupation occupation1 = new Occupation();
//    Room room1 = new Room();
//    Date dateTime1 = new Date();
//    dateTime1.setTime(1542776005000L);
//    Date dateTime2 = new Date();
//    dateTime2.setTime(1545368005000L);
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
////    addressService.sa
//    clientService.saveClient(client1);
////    roomService.saveRoom(room1);
//    reservationService.saveReservation(reservation1);
//    occupationService.saveOccupation(occupation1);
//
////    Iterable occupations = new LinkedList<>();
////    Iterable rooms = new LinkedList<>();
////    Iterable clients = new LinkedList<>();
////    clients = clientService.listAllClients();
////    rooms = roomService.listAllRooms();
    Iterable<Reservation> reservations = reservationService.listAllReservations();
//
    ObjectMapper jmapper = config.getJSONmapper();
    XmlMapper xmlMapper = config.getXMLmapper();

//    List<Reservation> reservations2;

    xmlMapper.writeValue(new File("reservations.xml"), reservations);
//    reservations2 = xmlMapper.readValue(new File("reservations.xml"), new TypeReference<List<Reservation>>(){});
//
//      for (Reservation r : reservations2) {
//        addressService.saveAddress(r.getClient().getAddress());
//        clientService.saveClient(r.getClient());
//        reservationService.saveReservation(r);
//      }
//
//        Iterable reservations = reservationService.listAllReservations();
//
        jmapper.writeValue(new File("reservations.json"), reservations);
//
//        Iterable<Reservation> reservations3 =
//                jmapper.readValue(new File("reservations.json"), new TypeReference<List<Reservation>>(){});
  }

}
