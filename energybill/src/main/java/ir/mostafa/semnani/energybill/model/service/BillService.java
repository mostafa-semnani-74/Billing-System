package ir.mostafa.semnani.energybill.model.service;

import ir.mostafa.semnani.energybill.model.entity.Bill;
import ir.mostafa.semnani.energybill.model.repository.BillDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillDA billDA;

    @Transactional
    public void save(Bill bill) {
        Double totalConsumption =  ((bill.getHighPeakConsumption()*0.1) + (bill.getNormalConsumption()*0.05) + (bill.getLowPeakConsumption()*0.02));
        totalConsumption = totalConsumption + (totalConsumption*(bill.getTax()/100)) - bill.getCredit() + bill.getDebit() ;
        bill.setTotalPayment(totalConsumption);
        billDA.save(bill);
    }
    @Transactional
    public void delete(Long id) { billDA.deleteById(id); }
    @Transactional
    public void update(Bill bill) {
        Double totalConsumption =  ((bill.getHighPeakConsumption()*0.1) + (bill.getNormalConsumption()*0.05) + (bill.getLowPeakConsumption()*0.02));
        totalConsumption = totalConsumption + (totalConsumption*(bill.getTax()/100)) - bill.getCredit() + bill.getDebit() ;
        bill.setTotalPayment(totalConsumption);
        billDA.update(bill.getBillId() ,bill.getFileNumber() , bill.getIdentificationCode() , bill.getComputerPassCode() , bill.getTariff() ,
                      bill.getElectricityPhase() , bill.getPeriod() , bill.getYear() , bill.getPaymentID() , bill.getPrompt() , bill.getTax() ,
                      bill.getCredit()
                    , bill.getDebit() , bill.getNormalConsumption() , bill.getHighPeakConsumption() , bill.getLowPeakConsumption() ,
                      bill.getTotalPayment());
    }

    public List<Bill> findAll() {
        return billDA.findAll();
    }
    public Bill findOneById(Long id) {
            return billDA.findById(id).get();
    }
}
