package fc.domain;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Justin on 4/09/2017.
 */
@Transactional
public interface ClientsRepository extends PagingAndSortingRepository<Clients,Long>, JpaSpecificationExecutor<Clients>{
    // Optional<SerialOnly> findFirstByOrderBySerialDesc();
//@Id
  //  long Client_ID();
}

