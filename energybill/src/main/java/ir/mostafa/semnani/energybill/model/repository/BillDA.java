package ir.mostafa.semnani.energybill.model.repository;

import ir.mostafa.semnani.energybill.model.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface BillDA extends JpaRepository<Bill, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE bill b SET b.fileNumber=:fileNumber , b.identificationCode=:identificationCode, b.computerPassCode=:computerPassCode" +
            ",b.tariff=:tariff, b.electricityPhase=:electricityPhase, b.period=:period , b.year=:year, b.paymentID=:paymentID , b.prompt=:prompt" +
            ",b.tax=:tax , b.credit=:credit, b.debit=:debit, b.normalConsumption=:normalConsumption, b.highPeakConsumption=:highPeakConsumption" +
            ",b.lowPeakConsumption=:lowPeakConsumption , b.totalPayment=:totalPayment  WHERE b.billId =:id")
    void update (@Param("id") Long id , @Param("fileNumber") Long fileNumber , @Param("identificationCode") Long identificationCode ,
                 @Param("computerPassCode") Long computerPassCode,
                 @Param("tariff") int tariff, @Param("electricityPhase") int electricityPhase, @Param("period") int period , @Param("year") int year,
                 @Param("paymentID") Float paymentID , @Param("prompt") Date prompt, @Param("tax") int tax , @Param("credit") Double credit,
                 @Param("debit") Double debit, @Param("normalConsumption") int normalConsumption,
                 @Param("highPeakConsumption") int highPeakConsumption , @Param("lowPeakConsumption") int lowPeakConsumption,
                 @Param("totalPayment") Double totalPayment) ;
}
