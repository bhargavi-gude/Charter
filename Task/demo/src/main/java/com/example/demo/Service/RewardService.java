package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Retailer;
import com.example.demo.repository.TransactionRepository;

@Service
public class RewardService {

    @Autowired
    private TransactionRepository repository;

    public int calculatePoints(Integer amount) {
        Integer points = 0;
        if (amount > 100) {
            points += ((amount - 100) * 2);
            points += 50;
        } else if (amount > 50) { 
            points += ((amount - 50) * 1);
        }
        return points;
    }

    public String getRewardPointsForLastThreeMonths(Integer retailerId) {

        if (retailerId == null) {
            return "The Retailer ID is missing.";
        }

        List<Retailer> list = repository.findByRetailerId(retailerId);
        Integer points = 0;

        points = list.stream().filter(customer -> customer.getTransactionDate().isAfter(LocalDate.now().minusMonths(3)))
                .mapToInt(customer -> calculatePoints(customer.getAmount())).sum();

        return "The retailer " + retailerId + "  earned the points " + points;
    }

}
