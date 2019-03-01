package com.eStorage.api.models.user;


import com.eStorage.api.models.orders.Orders;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Users")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "ID")
public class Users {
    private static final int MAX_NAME_LENGTH = 60;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "increment", strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "Status", length = MAX_NAME_LENGTH)
    private int status;

    @Column(name = "First_name", length = MAX_NAME_LENGTH)
    private String fName;

    @Column(name = "Last_name", length = MAX_NAME_LENGTH)
    private String lName;

    @Column(name = "Address", length = MAX_NAME_LENGTH)
    private String address;

    @Column(name = "Email", length = MAX_NAME_LENGTH, nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;

    @Column(name = "Password", length = MAX_NAME_LENGTH)
    private String password;

    @Column(name = "Role", length = MAX_NAME_LENGTH)
    private EnumUserRole role;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH},
            orphanRemoval = true, mappedBy = "user", targetEntity = Orders.class)
    private Set<Orders> orders;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EnumUserRole getRole() {
        return role;
    }

    public void setRole(EnumUserRole role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + '\'' +
                ", FirstName='" + fName + '\'' +
                ", LastName=" + lName + '\'' +
                ", Role=" + role + '\'' +
                ", Email=" + email + '\'' +
                ", Address=" + address +
                '}';
    }
}
