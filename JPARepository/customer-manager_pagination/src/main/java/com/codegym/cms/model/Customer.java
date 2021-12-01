package com.codegym.cms.model;

import javax.persistence.*;
import javax.validation.constraints.*;



@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Không để trống tên")
    @Size(min=2 ,max=45 , message = "Độ dài của tên từ 2 đến 45 kí tự")
    private String firstName;

    @Size(min=2 ,max=45, message = "Độ dài của họ từ 2 đến 45 kí tự")
    @NotEmpty(message = "Không để trống họ")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    public Customer() {}

    public Customer(@Size(min=2 ,max=45) String firstName,@Size(min=2 ,max=45) String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
