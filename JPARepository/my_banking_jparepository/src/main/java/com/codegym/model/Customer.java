package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phone;
    private String address;
    private long balance = 0 ;
    private boolean isDelete = false ;
    private LocalDateTime created_at = LocalDateTime.now();

    @OneToMany(targetEntity = Deposit.class, mappedBy = "customer")
    private List<Deposit> deposits;

    @OneToMany(targetEntity = Withdraw.class, mappedBy = "customer")
    private List<Withdraw> withdraws;

    @OneToMany(targetEntity = Transfer.class, mappedBy = "sender")
    private List<Transfer> senders;

    @OneToMany(targetEntity = Transfer.class, mappedBy = "recipient")
    private List<Transfer> recipients;

    public Customer(String fullName, String email, String phone, String address) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

}

