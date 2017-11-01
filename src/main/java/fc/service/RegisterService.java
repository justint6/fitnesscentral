package fc.service;

import fc.domain.Register;
import fc.domain.RegisterRepository;
import fc.domain.RegisterSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Justin on 9/09/2017.
 */

@Transactional(readOnly = true)
@Service
public class RegisterService {

    private final RegisterRepository registerRepository;

    @Autowired
    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public Register findSingleRecord(Register register, Integer Record_IDsearch){
        Specification<Register> spec = buildSpecSingleRecord(register, Record_IDsearch);
        return registerRepository.findOne(spec);
    }

    private Specification<Register> buildSpecSingleRecord(Register register, Integer Record_IDsearch){

    Specification<Register> Record_IDEquals = RegisterSpecifications.Record_IDEquals(Record_IDsearch);

    Specification<Register> specification = Specifications.where(Record_IDEquals);


    return specification;
}

}
