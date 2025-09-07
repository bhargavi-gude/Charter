package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Retailer;

@Repository
public interface TransactionRepository extends CrudRepository<Retailer, Integer>{
    
    List<Retailer> findByRetailerId(Integer retailerId);
}