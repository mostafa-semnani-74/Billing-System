package ir.mostafa.semnani.energybill.model.repository;


import ir.mostafa.semnani.energybill.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface CustomerDA extends JpaRepository<Customer, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE customer c SET c.nationalId=:nationalId , c.birthDate=:birthDate , c.firstName=:firstName , c.lastName=:lastName , c.fatherName=:fatherName , " +
            "c.address=:address , c.postalCode=:postalCode WHERE c.customerId=:id")
            void update(@Param("id") Long customerId, @Param("nationalId") Long nationalId, @Param("birthDate") Date birthDate, @Param("firstName") String firstName,
                         @Param("lastName") String lastName , @Param("fatherName") String fatherName, @Param("address") String address, @Param("postalCode") Long postalCode) ;
}
