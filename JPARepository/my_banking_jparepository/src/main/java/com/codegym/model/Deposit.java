package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "deposits")
public class Deposit {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long idOwner;
    private long amount;
    private boolean isDelete = false ;
    private LocalDateTime datetime = LocalDateTime.now();

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    public Deposit(){}

    public Deposit(Long idOwner) {
        this.idOwner = idOwner;
    }

    public Deposit(Long idOwner, Long amount) {
        this.idOwner = idOwner;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(long idOwner) {
        this.idOwner = idOwner;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean status) {
        this.isDelete = status;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
}
