package fc;
//Decent example of simple gradle spring boot application at https://spring.io/guides/gs/spring-boot/
/**
 * Created by Justin on 3/09/2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



}


//package fc;

//Decent example of simple gradle spring boot application at https://spring.io/guides/gs/spring-boot/

/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}*/