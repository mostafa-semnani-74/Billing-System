package ir.mostafa.semnani.energybill.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    @Column(columnDefinition = "NUMBER")
    private Long nationalId ;
    @Column(columnDefinition = "DATE")
    private Date birthDate ;
    @Column(columnDefinition = "VARCHAR2(50)")
    private String firstName ;
    @Column(columnDefinition = "VARCHAR2(100)")
    private String lastName ;
    @Column(columnDefinition = "VARCHAR2(50)")
    private String fatherName ;
    @Column(columnDefinition = "VARCHAR2(50)")
    private String address ;
    @Column(columnDefinition = "NUMBER")
    private Long postalCode ;

    @JsonIgnore
    @OneToMany (mappedBy = "customer" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    List<Bill> billList = new ArrayList<>();

    public Customer() { }

    public Customer(Long nationalId, Date birthDate, String firstName, String lastName, String fatherName, String address, Long postalCode, List<Bill> billList) {
        this.nationalId = nationalId;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.address = address;
        this.postalCode = postalCode;
        this.billList = billList;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getNationalId() {
        return nationalId;
    }

    public void setNationalId(Long nationalId) {
        this.nationalId = nationalId;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }
}
