package com.example.backendapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="CUST")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class
Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "FNAME")
    private String fname;

    @Column(name = "LNAME")
    private String lname;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ORGNR")
    private String orgnr;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFName(String name) {
        this.fname = name;
    }

    public String getLName() {
        return lname;
    }

    public void setLName(String name) {
        this.lname = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrgnr() {return orgnr;}

    public void setOrgnr(String orgnr) {this.orgnr = orgnr;}
}


