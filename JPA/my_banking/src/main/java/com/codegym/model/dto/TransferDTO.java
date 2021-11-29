package com.codegym.model.dto;


public class TransferDTO {

    private Long senderId ;
    private String senderName;
    private Long recipientId;
    private String recipientName;
    private long fees ;
    private long feesAmount;
    private long transferAmount ;

    public TransferDTO() {
    }

    public TransferDTO(Long senderId, String senderName, Long recipientId, String recipientName, long fees, long feesAmount, long transferAmount) {
        this.senderId = senderId;
        this.senderName = senderName;
        this.recipientId = recipientId;
        this.recipientName = recipientName;
        this.fees = fees;
        this.feesAmount = feesAmount;
        this.transferAmount = transferAmount;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public long getFees() {
        return fees;
    }

    public void setFees(long fees) {
        this.fees = fees;
    }

    public long getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(long feesAmount) {
        this.feesAmount = feesAmount;
    }

    public long getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(long transferAmount) {
        this.transferAmount = transferAmount;
    }
}
