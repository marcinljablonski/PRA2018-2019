package xd.marcin.hotel.controllers;

import xd.marcin.hotel.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xd.marcin.hotel.services.ClientService;
import xd.marcin.hotel.services.ReservationService;
import xd.marcin.hotel.services.RoomService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Homepage controller.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String index() {
        return "index";
    }


//    @RequestMapping(value = "generateModel", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
//    public String generateModel() {
//
//        LocalDateTime localtDateAndTime = LocalDateTime.now();
//        ZoneId zoneId = ZoneId.systemDefault();
//        ZonedDateTime dateAndTime  = ZonedDateTime.of(localtDateAndTime, zoneId);
//
//        Product p1 = new Product(UUID.randomUUID().toString(),"Jajko", new BigDecimal(2.50), dateAndTime.plusDays(7));
//        Product p2 = new Product(UUID.randomUUID().toString(),"Masło", new BigDecimal(3.50), dateAndTime.plusDays(7));
//        Product p3 = new Product(UUID.randomUUID().toString(),"Mąka", new BigDecimal(1.50), dateAndTime.plusDays(7));
//
//        productService.saveProduct(p1);
//        productService.saveProduct(p2);
//        productService.saveProduct(p3);
//
//        Seller seller = new Seller("Biedra", "Poznan", Arrays.asList(p1.getProductId(), p2.getProductId(), p3.getProductId()));
//        Seller seller2 = new Seller("Lidl", "Krosno", Arrays.asList(p1.getProductId(), p2.getProductId()));
//
//        sellerService.saveSeller(seller);
//        sellerService.saveSeller(seller2);
//
//        p1.getSellers().add(seller);
//        p2.getSellers().add(seller);
//        p3.getSellers().add(seller);
//        p1.getSellers().add(seller2);
//        p2.getSellers().add(seller2);
//
//        productService.saveProduct(p1);
//        productService.saveProduct(p2);
//        productService.saveProduct(p3);
//
//        return "Model Generated";
//    }

}
