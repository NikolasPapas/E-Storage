package com.eStorage.api.models.stores;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "person")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "ID")
public class Stores {
    private static final int MAX_NAME_LENGTH = 60;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "increment", strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "Name", length = MAX_NAME_LENGTH)
    private String name;

    @Column(name = "Status")
    private int status;

    @Column(name = "City")
    private int city;

    @Column(name = "Address", length = MAX_NAME_LENGTH)
    private String address;

    @Column(name = "Postal_code")
    private int postalCode;

    @Column(name = "Positions")
    private Long positions;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
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

    public Long getPositions() {
        return positions;
    }

    public void setPositions(Long positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + '\'' +
                ", Name='" + name + '\'' +
                ", City=" + city + '\'' +
                ", Postal Code=" + postalCode + '\'' +
                ", Address=" + address +
                ", Positions=" + positions +
                '}';
    }
}
