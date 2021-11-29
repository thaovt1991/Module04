package com.codegym.repository;

import com.codegym.model.Transfer;
import com.codegym.model.Withdraw;
import com.codegym.model.dto.TransferDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TransferRepository implements ITransferRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Transfer> findAll() {
        String hql ="select t from Transfer t where t.isDelete = false";
        TypedQuery<Transfer> query = entityManager.createQuery(hql, Transfer.class) ;
        return query.getResultList();
    }

    @Override
    public List<TransferDTO> findAllTransferDTO() {
        String hql = "SELECT \n" +
                "\ts.id AS senderId, \n" +
                "    s.fullname AS senderName,\n" +
                "    r.id AS recipientId, \n" +
                "    r.fullname AS recipientName,\n" +
                "    t.fees AS fees,\n" +
                "    t.feesAmount AS feesAmount,\n" +
                "    t.transferAmount AS transferAmount\n" +
                "FROM Transfer t\n" +
                "LEFT JOIN Customer s\n" +
                "ON\n" +
                "\ts.id = t.idSender\n" +
                "LEFT JOIN Customer r\n" +
                "ON\n" +
                "\tr.id = t.idRecipient";
//        Query query = entityManager.createNativeQuery(hql, TransferDTO.class);
        TypedQuery<TransferDTO> query = entityManager.createQuery(hql, TransferDTO.class) ;
        return query.getResultList();
    }

    @Override
    public Transfer findById(Long id) {
        String hql ="select t from Transfer t where t.isDelete = false and t.id =:id";
        TypedQuery<Transfer> query = entityManager.createQuery(hql,Transfer.class).setParameter("id",id) ;
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Transfer transfer) {
      if(transfer.getId()!= null){
          entityManager.merge(transfer) ;
      }else
          entityManager.persist(transfer);
    }

    @Override
    public void remove(Long id) {
        Transfer transfer = findById(id) ;
        if(transfer!=null){
            transfer.setDelete(true);
            entityManager.merge(transfer) ;
        }
    }
}
