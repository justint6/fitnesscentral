package fc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Justin on 26/10/2017.
 */
@Controller
@RequestMapping("/exercises")
public class ExercisesController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired

    public ExercisesController(){

    }

    @RequestMapping(value = "/")
    public String exercises() { return "exercises"; }
    //Thymeleaf is required for the autolink of http://127.0.0.1:8280/clients/ to the cleints.html
    //This also has to be place under the template resource directory.




    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(Exception.class)
    String handleException(HttpServletResponse response, Exception e) throws IOException {
        String msg = String.format("ExerciseController suffered an Exception: %s", e.getMessage());
        log.error(msg, e);

        return msg;
    }

}
