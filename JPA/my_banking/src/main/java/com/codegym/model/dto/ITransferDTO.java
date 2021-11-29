package com.codegym.model.dto;

public interface ITransferDTO {
    Long getSenderId();
    String getSenderName();
    Long getRecipientId();
    String getRecipientName();
    long getFees();
    long getFeesAmount();
    long getTransferAmount();
    long getTransactionAmount();
}
