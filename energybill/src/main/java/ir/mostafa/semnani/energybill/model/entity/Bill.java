package ir.mostafa.semnani.energybill.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.mostafa.semnani.energybill.common.creator.Developer;

import javax.persistence.*;
import java.sql.Date;

@Developer(creationDate = "2020" , developerName = "Mosi")
@Entity (name = "bill")
public class Bill {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long billId ;
    @Column(columnDefinition = "NUMBER")
    private Long fileNumber ; // shomare parvande
    @Column(columnDefinition = "NUMBER")
    private Long identificationCode ; // shenasayi
    @Column(columnDefinition = "NUMBER")
    private Long computerPassCode ; // ramz rayane
    @Column(columnDefinition = "NUMBER")
    private int tariff ; // tarefe
    @Column(columnDefinition = "NUMBER")
    private int electricityPhase; // phaze bargh tak phaz = 1 , 3 phaz = 3
    @Column(columnDefinition = "NUMBER")
    private int period ; // dore
    @Column(columnDefinition = "NUMBER")
    private int year ;
    @Column(columnDefinition = "NUMBER")
    private Float paymentID; // shenase pardakht
    @Column(columnDefinition = "NUMBER")
    private Double totalPayment ; // mablagh ghabel pardakht
    @Column(columnDefinition = "DATE")
    private Date prompt ; // mohlat pardakht
    @Column(columnDefinition = "NUMBER")
    private int tax ;
    @Column(columnDefinition = "NUMBER")
    private Double credit ; // bestankar
    @Column(columnDefinition = "NUMBER")
    private Double debit ; // bedehkar
    @Column(columnDefinition = "NUMBER")
    private int normalConsumption ; // miyan bari
    @Column(columnDefinition = "NUMBER")
    private int highPeakConsumption ; // oj bar
    @Column(columnDefinition = "NUMBER")
    private int lowPeakConsumption ; // kam bari

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    private String uiCustomerId;


    public Bill(){}

    public Bill(Long fileNumber, Long identificationCode, Long computerPassCode, int tariff, int electricityPhase, int period, int year, Float paymentID, Double totalPayment, Date prompt, int tax, Double credit, Double debit, int normalConsumption, int highPeakConsumption, int lowPeakConsumption, Customer customer, String uiCustomerId) {
        this.fileNumber = fileNumber;
        this.identificationCode = identificationCode;
        this.computerPassCode = computerPassCode;
        this.tariff = tariff;
        this.electricityPhase = electricityPhase;
        this.period = period;
        this.year = year;
        this.paymentID = paymentID;
        this.totalPayment = totalPayment;
        this.prompt = prompt;
        this.tax = tax;
        this.credit = credit;
        this.debit = debit;
        this.normalConsumption = normalConsumption;
        this.highPeakConsumption = highPeakConsumption;
        this.lowPeakConsumption = lowPeakConsumption;
        this.customer = customer;
        this.uiCustomerId = uiCustomerId;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(Long fileNumber) {
        this.fileNumber = fileNumber;
    }

    public Long getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(Long identificationCode) {
        this.identificationCode = identificationCode;
    }

    public Long getComputerPassCode() {
        return computerPassCode;
    }

    public void setComputerPassCode(Long computerPassCode) {
        this.computerPassCode = computerPassCode;
    }

    public int getTariff() {
        return tariff;
    }

    public void setTariff(int tariff) {
        this.tariff = tariff;
    }

    public int getElectricityPhase() {
        return electricityPhase;
    }

    public void setElectricityPhase(int electricityPhase) {
        this.electricityPhase = electricityPhase;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Float getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Float paymentID) {
        this.paymentID = paymentID;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Date getPrompt() {
        return prompt;
    }

    public void setPrompt(Date prompt) {
        this.prompt = prompt;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }

    public int getNormalConsumption() {
        return normalConsumption;
    }

    public void setNormalConsumption(int normalConsumption) {
        this.normalConsumption = normalConsumption;
    }

    public int getHighPeakConsumption() {
        return highPeakConsumption;
    }

    public void setHighPeakConsumption(int highPeakConsumption) {
        this.highPeakConsumption = highPeakConsumption;
    }

    public int getLowPeakConsumption() {
        return lowPeakConsumption;
    }

    public void setLowPeakConsumption(int lowPeakConsumption) {
        this.lowPeakConsumption = lowPeakConsumption;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getUiCustomerId() {
        return uiCustomerId;
    }

    public void setUiCustomerId(String uiCustomerId) {
        this.uiCustomerId = uiCustomerId;
    }
}
