package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RetailerDTO {

    private String retailerId;
    private LocalDate transactionDate;
    private double amount;

}
