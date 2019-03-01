package com.eStorage.api.entitys.items;

import com.eStorage.api.entitys.orders.Orders;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Items")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "ID")
public class Items {
    private static final int MAX_NAME_LENGTH = 60;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "increment", strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "Status")
    private int status;

    @Column(name = "Name", length = MAX_NAME_LENGTH)
    private String name;

    @Column(name = "Category", length = MAX_NAME_LENGTH)
    private String category;

    @Column(name = "BarCode", length = MAX_NAME_LENGTH)
    private String barCode;

    @Column(name = "Position", length = MAX_NAME_LENGTH)
    private String position;

    @Column(name = "Available")
    private Long available;

    @Column(name = "AllItems")
    private Long allItems;

    @Column(name = "Batch", length = MAX_NAME_LENGTH)
    private String batch;

    @Column(name = "ExpiredDate")
    private LocalDate expiredDate;

    @Column(name = "Price")
    private Float price;

    @ManyToMany
    @JoinTable(
            name = "Orders_Items",
            joinColumns = @JoinColumn(name = "items_id", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name = "orders_id", referencedColumnName="ID"))
    private Set<Orders> orders;


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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getAvailable() {
        return available;
    }

    public void setAvailable(Long available) {
        this.available = available;
    }

    public Long getAllItems() {
        return allItems;
    }

    public void setAllItems(Long allItems) {
        this.allItems = allItems;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "client{" + "id=" + id + '\'' +
                ", Status='" + status + '\'' +
                ", Name='" + name + '\'' +
                ", Category='" + category + '\'' +
                ", BarCode='" + barCode + '\'' +
                ", Available='" + available + '\'' +
                ", AllItems='" + allItems + '\'' +
                ", Batch='" + batch + '\'' +
                ", ExpiredDate='" + expiredDate + '\'' +
                ", Price='" + price + '\'' +
                '}';
    }
}