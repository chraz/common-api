package com.example.backendapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="customers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;*/

    @Id
    @Column(name = "CustomerID", nullable = false, length = 5)
    private String CustomerID;


    @Column(name= "CompanyName") //,  nullable = false, length = 40
    private String CompanyName;

    @Column(name = "ContactName")
    private String ContactName;

    @Column(name = "ContactTitle")
    private String ContactTitle;

    @Column(name = "Address")
    private String Address;

    @Column(name = "City")
    private String City;

    @Column(name = "Region")
    private String Region;

    @Column(name = "PostalCode")
    private String PostalCode;

    @Column(name = "Country")
    private String Country;

    @Column(name = "Phone")
    private String Phone;

    @Column(name = "Fax")
    private String Fax;

    @Column(name="con_id")
    private String con_id;

    @Column(name="id")
    private String id;

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactTitle() {
        return ContactTitle;
    }

    public void setContactTitle(String contactTitle) {
        ContactTitle = contactTitle;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    public String getCon_id() {
        return con_id;
    }

    public void setCon_id(String con_id) {
        this.con_id = con_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


