package fc.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Justin on 26/10/2017.
 */
@Transactional
public interface Exercise_ItemRepository extends PagingAndSortingRepository<Exercise_Item,Long>, JpaSpecificationExecutor<Exercise_Item> {
}


