package com.codegym.repository;

import com.codegym.model.Customer;
import com.codegym.model.Withdraw;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWithdrawRepository extends PagingAndSortingRepository<Withdraw,Long> {
}
