package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotEmpty(message = "First name not empty")
    @Size(min = 2 , max= 45)
    private String firstName ;

    @NotEmpty(message = "Last name not empty")
    @Size(min = 2 , max= 45)
    private String lastName ;

    @Pattern(regexp ="(^$|[0][0-9]{9,10}$)",message = "Formatter not true" )
//    @Size(min = 10 , max= 11)
    private String phoneNumber ;

    @Min(18)
    @Max(value = 100,message = "Wow,age !!!!!")
    private int age;

    @Pattern(regexp = "(^$|[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$)")
    private String email ;

    public User() {
    }

    public User( @NotEmpty(message = "First name not empty")
                 @Size(min = 2 , max= 45)String firstName,
                 @NotEmpty(message = "Last name not empty")
                 @Size(min = 2 , max= 45) String lastName,
                 @Pattern(regexp ="(^$|[0][0-9]{9,10}$)",message = "Formatter not true" )
                 @Size(min = 10 , max= 11) String phoneNumber,
                 @Min(18)
                 @Max(value = 100,message = "Wow,age !!!!!") int age,
                 @Pattern(regexp = "(^$|[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$)") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
