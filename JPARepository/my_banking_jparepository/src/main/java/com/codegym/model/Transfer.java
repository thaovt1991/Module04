package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name="transfers")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idSender ;
    private Long idRecipient;
    private long transferAmount ;
    private long fees ;
    private long feesAmount;
    private long transactionAmount;
    private boolean isDelete = false ;
    private LocalDateTime dateTime = LocalDateTime.now();

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    public Transfer() {
    }

    public Transfer(Long idSender, Long idRecipient, Long transferAmount) {
        this.idSender = idSender;
        this.idRecipient = idRecipient;
        this.transferAmount = transferAmount;
        this.fees = 10 ;
    }

    public Transfer(Long idSender) {
        this.idSender = idSender;
        this.fees = 10;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSender() {
        return idSender;
    }

    public void setIdSender(Long idSender) {
        this.idSender = idSender;
    }

    public Long getIdRecipient() {
        return idRecipient;
    }

    public void setIdRecipient(Long idRecipient) {
        this.idRecipient = idRecipient;
    }

    public long getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(long transferAmount) {
        this.transferAmount = transferAmount;
    }

    public long getFees() {
        return fees;
    }

    public void setFees(long fees) {
        this.fees = fees;
    }

    public long getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(long transaction_amount) {
        this.feesAmount = transaction_amount;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
