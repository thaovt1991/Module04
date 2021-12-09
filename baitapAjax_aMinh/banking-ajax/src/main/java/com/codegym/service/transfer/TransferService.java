package com.codegym.service.transfer;

import com.codegym.model.Transfer;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TransferService implements ITransferService{
    @Override
    public Iterable<Transfer> findAll() {
        return null;
    }

    @Override
    public Optional<Transfer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Transfer transfer) {

    }

    @Override
    public void remove(Long id) {

    }
}
