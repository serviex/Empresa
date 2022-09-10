package com.Serviex.Empresa.repositories;

import com.Serviex.Empresa.entities.Enterprice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EnterpriceRepository extends JpaRepository<Enterprice,Long> {
}
