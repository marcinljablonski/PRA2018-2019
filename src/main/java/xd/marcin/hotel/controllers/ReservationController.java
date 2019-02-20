package xd.marcin.hotel.controllers;

import xd.marcin.hotel.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import springfox.documentation.annotations.ApiIgnore;
import xd.marcin.hotel.entities.Reservation;
import xd.marcin.hotel.services.ClientService;
import xd.marcin.hotel.services.ReservationService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    ReservationService reservationService;


    @RequestMapping(value = "/reservations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Reservation> list(Model model) {
        return reservationService.listAllReservations();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/reservations", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Reservation> redirect(Model model) {
        return reservationService.listAllReservations();
    }

    @RequestMapping(value = "/reservation/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Reservation> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return reservationService.listAllReservationsPaging(pageNr, howManyOnPage.orElse(2));
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Reservation getByPublicId(@PathVariable("id") Integer publicId) {
        return reservationService.getReservationById(publicId);
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Reservation getByParamPublicId(@RequestParam("id") Integer publicId) {
        return reservationService.getReservationById(publicId);
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public ResponseEntity<Reservation> create(@RequestBody @Valid @NotNull Reservation reservation) {
        reservation.setId(Integer.parseInt(UUID.randomUUID().toString()));
        reservationService.saveReservation(reservation);
        return ResponseEntity.ok().body(reservation);
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Reservation reservation) {
        if(!reservationService.checkIfExist(reservation.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            reservationService.saveReservation(reservation);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        reservationService.deleteReservation(id);
        return new RedirectView("/index", true);
    }
}
