package ir.mostafa.semnani.energybill.model.service;

import ir.mostafa.semnani.energybill.model.entity.Bill;
import ir.mostafa.semnani.energybill.model.entity.Customer;
import ir.mostafa.semnani.energybill.model.repository.CustomerDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDA customerDA;

    @Transactional
    public void save(Customer customer) { customerDA.save(customer); }
    @Transactional
    public void delete(Long id) { customerDA.deleteById(id); }
    @Transactional
    public void update(Customer customer) {
        customerDA.update(customer.getCustomerId() ,customer.getNationalId() , customer.getBirthDate() , customer.getFirstName() ,
                          customer.getLastName() , customer.getFatherName() , customer.getAddress() , customer.getPostalCode());
    }

    public List<Customer> findAll() {
        return customerDA.findAll();
    }
    public Customer findOneById(Long id) { return  customerDA.findById(id).get(); }
}

