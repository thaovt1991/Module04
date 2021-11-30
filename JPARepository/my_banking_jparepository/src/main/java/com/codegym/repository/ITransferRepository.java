package com.codegym.repository;

import com.codegym.model.Deposit;
import com.codegym.model.Transfer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferRepository extends PagingAndSortingRepository<Transfer,Long> {
}
