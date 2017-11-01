package fc.controller;

import fc.domain.Clients;
import fc.domain.ClientsRepository;
import fc.service.ClientsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * Created by Justin on 7/09/2017.
 * Browsing to /clients/values/?Client_IDsearch=1 will return a JSON packet with the resultant List<Clients> dataset
 * Browsing to /clients/singlevalue/?Client_IDseach=1 will return a JSON packet with the resultant single Clients dataset
 */

@Controller
@RequestMapping("/clients")
public class ClientsController {
    private Long Client_ID;
    private String First_Name;
    private String Client_Address;
    private Integer Phone_Number;
    private Integer Mobile_Number;
    private String Email_Address;

    private static final Logger log = LoggerFactory.getLogger(ClientsController.class);

    private final ClientsService clientsService;

    @Autowired

    public ClientsController(ClientsService clientsService){
        this.clientsService = clientsService;
    }

    @RequestMapping(value = "/")
    public String clients() { return "clients"; }
    //Thymeleaf is required for the autolink of http://127.0.0.1:8280/clients/ to the cleints.html
    //This also has to be place under the template resource directory.


    @RequestMapping(value = "/create")
    ResponseEntity<String> createClients(String First_Name, String Client_Address, Integer Phone_Number, Integer Mobile_Number, String Email_Address) {
        try {

            Clients clientscreate = new Clients();
            clientscreate.setFirst_Name(First_Name);
            clientscreate.setPhone_Number(Phone_Number);
            clientscreate.setMobile_Number(Mobile_Number);
            clientscreate.setEmail_Address(Email_Address);
            clientscreate.setClient_Address(Client_Address);

            clientsRepository.save(clientscreate);

        } catch (Exception ex) {
            if (ex.toString() == ".javalang.NullPointerException") {
                return new ResponseEntity<String>(ex.toString(), HttpStatus.NOT_FOUND);
                //'No Profile Exists for user'
            } else {
                return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
                //"Error updating the profile: " + ex.toString();
            }
        }

        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @Autowired
    private ClientsRepository clientsRepository;

    @RequestMapping(value = "/values", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Clients> search(@Valid @ModelAttribute("form")
                                        ClientsForm form,
                                        BindingResult result,
                                        @RequestParam(value = "Client_IDsearch", required = true) Long Client_IDsearch) throws Exception {




        log.info("/clients/values/; Form = {}", form);

        if (result.hasErrors())
            throw new IllegalArgumentException("Cannot validate incoming Form instance: " + result);

        return clientsService.findFilteredClients(form, Client_IDsearch);
    }


    @RequestMapping(value = "/allclients", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Page<Clients> search(@Valid @ModelAttribute("form")
                                ClientsForm form,
                                BindingResult result
                                ) throws Exception {




        log.info("/allclients; Form = {}", form);

        if (result.hasErrors())
            throw new IllegalArgumentException("Cannot validate incoming Form instance: " + result);

        return clientsService.findAllClients();
    }









    @RequestMapping(value = "/singlevalue", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Clients search(@Valid @ModelAttribute("clients")
                                Clients clients,
                                BindingResult result,
                                @RequestParam(value = "Client_IDsearch", required = true) Long Client_IDsearch) throws Exception {

        //Browsing to /clients/values/?Client_IDsearch=1 will return a JSON packet with the resultant dataset


        log.info("/clients/values/; Form = {}", clients);

        if (result.hasErrors())
            throw new IllegalArgumentException("Cannot validate incoming Form instance: " + result);

        return clientsService.findSingleClient(clients, Client_IDsearch);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    String handleException(HttpServletResponse response, Exception e) throws IOException {
        String msg = String.format("ProfileController suffered an Exception: %s", e.getMessage());
        log.error(msg, e);

        return msg;
    }
}