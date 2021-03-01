package ir.mostafa.semnani.energybill.controller;


import ir.mostafa.semnani.energybill.model.entity.Bill;
import ir.mostafa.semnani.energybill.model.entity.Customer;
import ir.mostafa.semnani.energybill.model.repository.BillDA;
import ir.mostafa.semnani.energybill.model.repository.CustomerDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestControllerBillAndCustomer {
    @Autowired
    BillDA billDA;
    @Autowired
    CustomerDA customerDA;


    //localhost:8081/user/rest/bill
    @GetMapping("/user/rest/bill")
    List<Bill> restFindAllBill() {
        return billDA.findAll();
    }
    @GetMapping("/user/rest/customer")
    List<Customer> restFindAllCustomer() {
        return customerDA.findAll();
    }

    //localhost:8081/user/rest/bill/1
    @GetMapping("/user/rest/bill/{id}")
    Bill restFindBillById(@PathVariable Long id) { return billDA.findById(id).get(); }
    @GetMapping("/user/rest/customer/{id}")
    Customer restFindCustomerById(@PathVariable Long id) {
        return  customerDA.findById(id).get();
    }

    @PostMapping("/user/rest/bill")
    Bill saveBill(@RequestBody Bill bill) {
       return billDA.save(bill);
    }
    @PostMapping("/user/rest/customer")
    Customer saveCustomer(@RequestBody Customer customer) {
        return  customerDA.save(customer);
    }

    @PutMapping("/user/rest/bill/{id}")
    Bill restUpdateBillById(@RequestBody Bill newBill, @PathVariable Long id) {
        return billDA.findById(id)
                .map(bill -> {
                    bill.setFileNumber(newBill.getFileNumber());
                    bill.setIdentificationCode(newBill.getIdentificationCode());
                    bill.setComputerPassCode(newBill.getComputerPassCode());
                    bill.setTariff(newBill.getTariff());
                    bill.setElectricityPhase(newBill.getElectricityPhase());
                    bill.setPeriod(newBill.getPeriod());
                    bill.setYear(newBill.getYear());
                    bill.setPaymentID(newBill.getPaymentID());
                    bill.setPrompt(newBill.getPrompt());
                    bill.setTax(newBill.getTax());
                    bill.setCredit(newBill.getCredit());
                    bill.setDebit(newBill.getDebit());
                    bill.setNormalConsumption(newBill.getNormalConsumption());
                    bill.setHighPeakConsumption(newBill.getHighPeakConsumption());
                    bill.setLowPeakConsumption(newBill.getLowPeakConsumption());

                    Double totalConsumption =  ((newBill.getHighPeakConsumption()*0.1) + (newBill.getNormalConsumption()*0.05) + (newBill.getLowPeakConsumption()*0.02));
                    totalConsumption = totalConsumption + (totalConsumption*(newBill.getTax()/100)) - newBill.getCredit() + newBill.getDebit() ;
                    bill.setTotalPayment(totalConsumption);

                    return billDA.save(bill);
                })
                .orElseGet(() -> {
                    newBill.setBillId(id);
                    return billDA.save(newBill);
                });
    }
    @PutMapping("/user/rest/customer/{id}")
    Customer restUpdateCustomerById(@RequestBody Customer newCustomer , @PathVariable Long id) {
        return customerDA.findById(id)
                .map(customer -> {
                    customer.setNationalId(newCustomer.getNationalId());
                    customer.setBirthDate(newCustomer.getBirthDate());
                    customer.setFirstName(newCustomer.getFirstName());
                    customer.setLastName(newCustomer.getLastName());
                    customer.setFatherName(newCustomer.getFatherName());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setPostalCode(newCustomer.getPostalCode());
                    return customerDA.save(customer);
                })
                .orElseGet(() -> {
                    newCustomer.setCustomerId(id);
                    return customerDA.save(newCustomer);
                });
    }

    @DeleteMapping("/user/rest/bill/{id}")
    void restDeleteBill(@PathVariable Long id) {
        billDA.deleteById(id);
    }
    @DeleteMapping("/user/rest/customer/{id}")
    void restDeleteCustomer(@PathVariable Long id) {
        customerDA.deleteById(id);
    }


}
