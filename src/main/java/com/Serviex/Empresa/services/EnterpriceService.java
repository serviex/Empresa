package com.Serviex.Empresa.services;

import com.Serviex.Empresa.entities.Employee;
import com.Serviex.Empresa.entities.Enterprice;
import com.Serviex.Empresa.entities.Transaction;
import com.Serviex.Empresa.repositories.EnterpriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EnterpriceService {
    private EnterpriceRepository enterpriceRepository;
    public EnterpriceService(EnterpriceRepository enterpriceRepository) {
        this.enterpriceRepository = enterpriceRepository;
    }

    public List<Enterprice> getEnterprices(){
        return this.enterpriceRepository.findAll();
    }

    public Enterprice getEnterprice(long id){
        Optional<Enterprice> enterprice = this.enterpriceRepository.findById(id);
        return enterprice.orElse(null);
    }

    public Enterprice createEnterprice(Enterprice enterprice){
        enterprice.setCreateAt(LocalDate.now());
        return this.enterpriceRepository.save(enterprice);
    }

    public Enterprice createTransaction(Transaction transaction,long idEnterprice){
        Enterprice enterprice = this.getEnterprice(idEnterprice);
        var employees =enterprice.getEmployees().stream().findFirst();
        if(employees.isPresent()) {
            var employee = employees.get();
            employee.setCreateAt(LocalDate.now());
            employee.addTransaction(transaction);
        }
        enterprice.setCreateAt(LocalDate.now());
        enterprice.addTransaction(transaction);
        return this.enterpriceRepository.save(enterprice);
    }

    public Enterprice updateEnterprice(long id, Enterprice enterprice){
        Optional<Enterprice> dbData = this.enterpriceRepository.findById(id);

        if(dbData.isPresent()){
            Enterprice e = dbData.get();
            e.setName(enterprice.getName());
            e.setDocument(enterprice.getDocument());
            e.setPhone(enterprice.getPhone());
            e.setAddress(enterprice.getAddress());
            e.setUpdateAt(LocalDate.now());
            this.enterpriceRepository.save(e);
            return e;
        }

        return null;
    }
    public Boolean deleteTransaction(long id, Transaction transaction){
        try{
            Enterprice enterprice = this.getEnterprice(id);
            enterprice.removeTransaction(transaction);
            this.enterpriceRepository.save(enterprice);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public Boolean deleteEnterprice(Long id){
        try{
            this.enterpriceRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
