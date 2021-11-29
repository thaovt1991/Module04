package com.codegym.service;

import com.codegym.model.Transfer;
import com.codegym.model.dto.ITransferDTO;
import com.codegym.model.dto.TransferDTO;

import java.util.List;

public interface ITransferService extends IGeneralService<Transfer>{
    List<TransferDTO> findAllTransferDTO();

    List<ITransferDTO> findAllITransferDTO();
}
