package fc.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Justin on 9/09/2017.
 */
@Transactional
public interface RegisterRepository extends PagingAndSortingRepository<Register,Integer>, JpaSpecificationExecutor<Register> {
}
