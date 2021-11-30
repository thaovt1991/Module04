package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

        Iterable<Customer> findAllByProvince(Province province);


        Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);

        Page<Customer> findAllById(Long id, Pageable pageable);

        Page<Customer> findAllByLastNameContaining(String keysearch, Pageable pageable);



}
