package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "deposits")
public class Deposit {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private LocalDateTime created_at;
    private Long create_by ;

    @Digits(integer= 12,fraction= 0)
    private BigDecimal transaction_amount;

    private boolean isDelete = false ;
    private LocalDateTime update_at;
    private Long update_by ;



    public Deposit(Long id, Customer customer, BigDecimal transaction_amount) {
        this.id = id;
        this.customer = customer;
        this.transaction_amount = transaction_amount;
    }

}
