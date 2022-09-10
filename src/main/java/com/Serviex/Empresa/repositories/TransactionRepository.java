package com.Serviex.Empresa.repositories;

import com.Serviex.Empresa.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
