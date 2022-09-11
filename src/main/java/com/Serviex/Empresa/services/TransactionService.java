package com.Serviex.Empresa.services;

import com.Serviex.Empresa.entities.Transaction;
import com.Serviex.Empresa.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactions(){

        return this.transactionRepository.findAll();
    }

    public Transaction getTransaction(long id){
        Optional<Transaction> enterprice = this.transactionRepository.findById(id);
        return enterprice.orElse(null);
    }

    public Transaction createTransaction(Transaction transaction){
        transaction.setCreateAt(LocalDate.now());
        return this.transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(long id, Transaction transaction){
        Optional<Transaction> dbData = this.transactionRepository.findById(id);

        if(dbData.isPresent()){
            Transaction e = dbData.get();
            e.setAmount(transaction.getAmount());
            e.setConcept(transaction.getConcept());
            e.setUpdateAt(LocalDate.now());
            this.transactionRepository.save(e);
            return e;
        }

        return null;
    }

    public Boolean deleteTransaction(Long id){
        try{
            this.transactionRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
