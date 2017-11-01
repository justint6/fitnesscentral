package fc.controller;

import fc.domain.Register;
import fc.domain.RegisterRepository;
import fc.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Justin on 9/09/2017.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {


    private static final Logger log = LoggerFactory.getLogger(ClientsController.class);

    private final RegisterService registerService;

    @Autowired

    public RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }

    @RequestMapping(value = "/")
    public String register() { return "register"; }
    //Thymeleaf is required for the autolink of http://127.0.0.1:8280/register/ to the register.html
    //This also has to be place under the template resource directory.

    @RequestMapping(value = "/create")
    ResponseEntity<String> createClients(Integer Client_ID, String Record_Date, Integer Training_Session_ID, String Session_Type, String Status, Integer Group_ID) {
        try {


                String datestr= Record_Date;
                DateFormat formatter;
                Date startDate;
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                startDate = (Date)formatter.parse(datestr);

            Register registercreate = new Register();
            registercreate.setClient_ID(Client_ID);
            registercreate.setRecord_Date(startDate);
            registercreate.setTraining_Session_ID(Training_Session_ID);
            registercreate.setSession_Type(Session_Type);
            registercreate.setStatus(Status);
            registercreate.setGroup_ID(Group_ID);

            registerRepository.save(registercreate);

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
    private RegisterRepository registerRepository;


}
