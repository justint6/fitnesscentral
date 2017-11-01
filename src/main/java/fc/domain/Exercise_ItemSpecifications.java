package fc.domain;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Path;

/**
 * Created by Justin on 26/10/2017.
 */
public class Exercise_ItemSpecifications {
    private Exercise_ItemSpecifications() {}

    public static Specification<Exercise_Item> Exercise_IDEquals(final Integer ExerciseIDspec) {
        return (root, query, cb) -> {
            Path<String> Exercise_IDPath = root.get("Exercise_ID");
            return cb.equal(Exercise_IDPath, ExerciseIDspec);
        };
    }
}
