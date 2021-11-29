package com.codegym.repository;

import com.codegym.model.Transfer;
import com.codegym.model.dto.ITransferDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferTempRepository extends JpaRepository<Transfer, Long> {

    @Query("SELECT \n" +
            "\ts.id AS senderId, \n" +
            "    s.fullname AS senderName,\n" +
            "    r.id AS recipientId, \n" +
            "    r.fullname AS recipientName,\n" +
            "    t.fees AS fees,\n" +
            "    t.feesAmount AS feesAmount,\n" +
            "    t.transferAmount AS transferAmount,\n" +
            "    t.transferAmount + t.feesAmount AS transactionAmount\n" +
            "FROM Transfer t\n" +
            "LEFT JOIN Customer s\n" +
            "ON\n" +
            "\ts.id = t.idSender\n" +
            "LEFT JOIN Customer r\n" +
            "ON\n" +
            "\tr.id = t.idRecipient")
    List<ITransferDTO> findAllITransferDTO();
}
