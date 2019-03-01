package com.eStorage.api.entitys.orders;

import com.eStorage.api.entitys.client.Clients;
import com.eStorage.api.entitys.items.Items;
import com.eStorage.api.entitys.user.Users;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Orders")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "ID")
public class Orders {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "increment", strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "Status")
    private int status;

    @Column(name = "OrderDate")
    private LocalDate orderDate;

    @Column(name = "DeliveryDate")
    private LocalDate deliveryDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "UserId", referencedColumnName = "ID", nullable = false)
    private Users user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ClientId", referencedColumnName = "ID", nullable = false)
    private Clients client;

    @ManyToMany(mappedBy = "orders")
    private Set<Items> items;

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

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "client{" + "id=" + id + '\'' +
                ", Status='" + status + '\'' +
                ", Order Date=" + orderDate + '\'' +
                ", Delivery Date=" + deliveryDate + '\'' +
                ", User Id= { " + user.toString() + " }" + '\'' +
                ", client=" + "{ " + client.toString() + " }" + '\'' +
                '}';
    }
}
