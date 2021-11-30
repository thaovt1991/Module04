package com.codegym.repository;

import com.codegym.model.Deposit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepositRepository extends PagingAndSortingRepository<Deposit,Long> {

}
