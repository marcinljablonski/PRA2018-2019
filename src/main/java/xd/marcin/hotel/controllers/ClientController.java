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
import xd.marcin.hotel.services.ClientService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Product controller.
 */
@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientService clientService;


    /**
     * List all products.
     *
     */
    @RequestMapping(value = "/clients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Client> list(Model model) {
        return clientService.listAllClients();
    }

    // Only for redirect!
    @ApiIgnore
    @RequestMapping(value = "/clients", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Client> redirect(Model model) {
        return clientService.listAllClients();
    }

    @RequestMapping(value = "/client/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Client> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return clientService.listAllClientsPaging(pageNr, howManyOnPage.orElse(2));
    }


    /**
     * View a specific product by its id.
     *
     */
    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getByPublicId(@PathVariable("id") Integer publicId) {
        return clientService.getClientById(publicId);
    }

    /**
     * View a specific product by its id.
     *
     */
    @RequestMapping(value = "/client", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getByParamPublicId(@RequestParam("id") Integer publicId) {
        return clientService.getClientById(publicId);
    }

    /**
     * Save product to database.
     *
     */
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public ResponseEntity<Client> create(@RequestBody @Valid @NotNull Client client) {
        client.setId(Integer.parseInt(UUID.randomUUID().toString()));
        clientService.saveClient(client);
        return ResponseEntity.ok().body(client);
    }


    /**
     * Edit product in database.
     *
     */
    @RequestMapping(value = "/client", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Client client) {
        if(!clientService.checkIfExist(client.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            clientService.saveClient(client);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(HttpServletResponse response, @PathVariable Integer id) {
        clientService.deleteClient(id);
        return new RedirectView("/XD", true);
    }
}
