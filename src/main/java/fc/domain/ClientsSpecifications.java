package fc.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Justin on 7/09/2017.
 * Specifications Class provides the hibernate SQL statements to be run against the database.
 */
public class ClientsSpecifications {

    private ClientsSpecifications() { }



    public static Specification<Clients> Client_IDEquals(final Long ClientIDspec) {
        return (root, query, cb) -> {
            Path<String> Client_IDPath = root.get("Client_ID");
            return cb.equal(Client_IDPath, ClientIDspec);
        };
    }



    public static Specification<Clients> valueIn(List<String> value) {
        return (root, query, cb) -> {
            Path<String> valuePath = root.get("value");

            Set<String> upperValue = value.stream().map(String::toUpperCase).collect(Collectors.toSet());
            Predicate sp = cb.upper(valuePath).in(upperValue);
            return cb.and(sp);
        };
    }


    public static Specification<Clients> fieldEquals(final String fieldspec) {
        return (root, query, cb) -> {
            Path<String> fieldPath = root.get("field");

            //Set<String> upperUsername = field
            return cb.equal(fieldPath, fieldspec);
            //return cb.notEqual(usernamePath, usernamespec);
        };
    }

    public static Specification<Clients> usernameEquals(final String usernamespec) {
        return (root, query, cb) -> {
            Path<String> usernamePath = root.get("username");

            //Set<String> upperUsername = username
            return cb.equal(usernamePath, usernamespec);
            //return cb.notEqual(usernamePath, usernamespec);
        };
    }

}
