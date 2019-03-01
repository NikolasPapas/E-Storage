package com.eStorage.api.models.client;

import com.eStorage.api.models.orders.Orders;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Client")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "ID")
public class Client {
    private static final int MAX_NAME_LENGTH = 60;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "increment", strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "Status")
    private int status;

    @Column(name = "Name", length = MAX_NAME_LENGTH)
    private String name;

    @Column(name = "Brand", length = MAX_NAME_LENGTH)
    private String brand;

    @Column(name = "AFM", length = MAX_NAME_LENGTH)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String afm;

    @Column(name = "Occupation", length = MAX_NAME_LENGTH)
    private String occupation;

    @Column(name = "Doy", length = MAX_NAME_LENGTH)
    private String doy;

    @Column(name = "City", length = MAX_NAME_LENGTH)
    private String city;

    @Column(name = "Address", length = MAX_NAME_LENGTH)
    private String address;

    @Column(name = "Postal_code", length = MAX_NAME_LENGTH)
    private int postalCode;

    @Column(name = "Email", length = MAX_NAME_LENGTH, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;

    @Column(name = "PhoneNumber", length = MAX_NAME_LENGTH)
    private int phoneNumber;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH},
            orphanRemoval = true, mappedBy = "client", targetEntity = Orders.class)
    private List<Orders> orders;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAfm() {
        return afm;
    }

    public void setAfm(String afm) {
        this.afm = afm;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDoy() {
        return doy;
    }

    public void setDoy(String doy) {
        this.doy = doy;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Brand=" + brand + '\'' +
                ", Occupation=" + occupation + '\'' +
                ", Email=" + email + '\'' +
                ", Phone=" + phoneNumber + '\'' +
                ", City=" + city + '\'' +
                ", Postal Code=" + postalCode + '\'' +
                ", Address=" + address +
                '}';
    }

}
