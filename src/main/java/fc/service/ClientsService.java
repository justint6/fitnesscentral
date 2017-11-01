package fc.service;

import fc.controller.ClientsForm;
import fc.domain.Clients;
import fc.domain.ClientsRepository;
import fc.domain.ClientsSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Justin on 7/09/2017.
 */

@Transactional(readOnly = true)
@Service
public class ClientsService {

    @Resource(name = "clientsRepository")
    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public List<Clients> findFilteredClients(ClientsForm form, Long Client_IDsearch) {
        Specification<Clients> spec = buildSpec(form, Client_IDsearch);
        return clientsRepository.findAll(spec);
    }

    public Page<Clients> findAllClients() {
        //some non working code found at https://www.programcreek.com/java-api-examples/index.php?source_dir=slipp-master/src/main/java/net/slipp/service/smalltalk/SmallTalkService.java
        // other Paging examples https://www.programcreek.com/java-api-examples/index.php?api=org.springframework.data.domain.Page
        //Code that finally worked from https://stackoverflow.com/questions/41892105/how-can-i-get-all-the-records-for-findall-service-using-pagination-and-spring
        long counter = clientsRepository.count(); //total number of records that can be used below instead of the 20.
        Page<Clients> clients = clientsRepository.findAll(new PageRequest(0,20));

        //List<Clients> orgclients = page.getContent();
        //List<Clients> clientList = new ArrayList<>();
        //for (Clients clients : orgclients) {
         //   clientList.add(clients);
        //}
        return  clients;
    }

    private PageRequest getPager() {
        return new PageRequest(0, 10, sortByIdAsc());
    }

    private Sort sortByIdAsc(){
        return new Sort(Sort.Direction.ASC, "Client_ID");
    }

    public Clients findSingleClient(Clients clients, Long Client_IDsearch){
        Specification<Clients> spec = buildSpecSingleClient(clients, Client_IDsearch);
        return clientsRepository.findOne(spec);
    }

    // Page type is for the pagination of a large amount of returned records.
    public Page<Clients> findFilteredClients(ClientsForm form, Long Client_IDsearch, Pageable pageable) {
        Specification<Clients> spec = buildSpec(form, Client_IDsearch);

        return clientsRepository.findAll(spec, pageable);
    }


    private Specification<Clients> buildSpec(ClientsForm form, Long Client_IDsearch) {


        Specification<Clients> ClientIDEquals = ClientsSpecifications.Client_IDEquals(Client_IDsearch);

        Specification<Clients> specification = Specifications.where(ClientIDEquals);
        //Specification<CAProfileValues> specification = Specifications.where(usernameEquals);

        //List<Long> field = form.getClient_ID();
        //if (!CollectionUtils.isEmpty(field))
         //   specification = Specifications.where(specification).and(ClientsSpecifications.fieldIn(field));

        //List<String> value = form.getFirst_Name();
        //if (!CollectionUtils.isEmpty(value))
         //   specification = Specifications.where(specification).and(ClientsSpecifications.valueIn(value));


        return specification;
    }



    private Specification<Clients> buildSpecSingleClient(Clients clients, Long Client_IDsearch) {


        Specification<Clients> ClientIDEquals = ClientsSpecifications.Client_IDEquals(Client_IDsearch);

        Specification<Clients> specification = Specifications.where(ClientIDEquals);
        //Specification<CAProfileValues> specification = Specifications.where(usernameEquals);

        //List<Long> field = form.getClient_ID();
        //if (!CollectionUtils.isEmpty(field))
        //   specification = Specifications.where(specification).and(ClientsSpecifications.fieldIn(field));

        //List<String> value = form.getFirst_Name();
        //if (!CollectionUtils.isEmpty(value))
        //   specification = Specifications.where(specification).and(ClientsSpecifications.valueIn(value));


        return specification;
    }


}


