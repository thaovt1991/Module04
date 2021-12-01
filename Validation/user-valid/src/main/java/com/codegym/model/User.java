package com.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class User implements Validator {
    private String firstName ;
    private String lastName ;
    private String phoneNumber ;
    private int age;
    private String email ;

    public User() {
    }

    public User(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;
        String firstName = user.getFirstName() ;
        String lastName = user.getLastName();
        String phoneNumber = user.getPhoneNumber();
        int age = user.getAge() ;
        String email = user.getEmail() ;

        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");

        if (firstName.length()<5 || firstName.length()>45){
            errors.rejectValue("firstName", "firstName.length");
        }

        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastName.empty");

        if (lastName.length()<5 || lastName.length()>45){
            errors.rejectValue("lastName", "lastName.length");
        }

        ValidationUtils.rejectIfEmpty(errors, "age", "age.empty");

        if (age < 18 || age > 100){
            errors.rejectValue("age", "age.limit");
        }

        if (!email.matches("(^$|[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$)")){
            errors.rejectValue("email", "email.matches");
        }

        if (!phoneNumber.matches("(^$|[0][0-9]{9,10}$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
        //        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
//        if (phoneNumber.length()>11 || phoneNumber.length()<10){
//            errors.rejectValue("phoneNumber", "phoneNumber.length");
//        }
//        if (!phoneNumber.startsWith("0")){
//            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
//        }

    }

}
