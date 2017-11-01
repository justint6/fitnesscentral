package fc.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;

/**
 * Created by Justin on 9/09/2017.
 */
public class RegisterSpecifications {
        private RegisterSpecifications() {}

    public static Specification<Register> Record_IDEquals(final Integer RecordIDspec) {
        return (root, query, cb) -> {
            Path<String> Record_IDPath = root.get("Record_ID");
            return cb.equal(Record_IDPath, RecordIDspec);
        };
    }
}
