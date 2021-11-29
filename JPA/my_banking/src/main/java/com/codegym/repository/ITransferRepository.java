package com.codegym.repository;

import com.codegym.model.Transfer;
import com.codegym.model.dto.TransferDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITransferRepository extends IGeneralRepository<Transfer> {
    List<TransferDTO> findAllTransferDTO();
}
