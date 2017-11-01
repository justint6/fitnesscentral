package fc.service;

import fc.domain.Exercise_Item;
import fc.domain.Exercise_ItemRepository;
import fc.domain.Exercise_ItemSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Justin on 26/10/2017.
 */

@Transactional(readOnly = true)
@Service
public class Exercise_ItemService {

        private final Exercise_ItemRepository exercise_itemRepository;

        @Autowired
        public Exercise_ItemService(Exercise_ItemRepository exercise_itemRepository) {
            this.exercise_itemRepository = exercise_itemRepository;
        }

        public Exercise_Item findSingleRecord(Exercise_Item exercise_item, Integer Exercise_IDsearch){
            Specification<Exercise_Item> spec = buildSpecSingleRecord(exercise_item, Exercise_IDsearch);
            return exercise_itemRepository.findOne(spec);
        }

        private Specification<Exercise_Item> buildSpecSingleRecord(Exercise_Item exercise_item, Integer Exercise_IDsearch){

            Specification<Exercise_Item> Exercise_IDEquals = Exercise_ItemSpecifications.Exercise_IDEquals(Exercise_IDsearch);

            Specification<Exercise_Item> specification = Specifications.where(Exercise_IDEquals);


            return specification;
        }

 }

