package com.eStorage.api.models.orders;

import com.eStorage.api.models.client.Client;
import com.eStorage.api.models.items.Items;
import com.eStorage.api.models.user.Users;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
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
    private Client client;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Items_Orders",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "order_Id", referencedColumnName = "ID"))
    private Set<Items> orderedItems = new HashSet<>();

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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Items> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(Set<Items> orderedItems) {
        this.orderedItems = orderedItems;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + '\'' +
                ", Status='" + status + '\'' +
                ", Order Date=" + orderDate + '\'' +
                ", Delivery Date=" + deliveryDate + '\'' +
                ", User Id= { " + user.toString() + " }" + '\'' +
                ", Client=" + "{ " + client.toString() + " }" + '\'' +
                ", Ordered Items= { " + orderedItems.stream().findAny().toString() + " }" + '\'' +
                '}';
    }
}
