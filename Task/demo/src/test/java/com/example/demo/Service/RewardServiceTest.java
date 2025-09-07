package com.example.demo.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Retailer;
import com.example.demo.repository.TransactionRepository;
@SpringBootTest
class RewardServiceTest {

    @InjectMocks
    private RewardService rewardService;

    @Mock
    private TransactionRepository repository;
    
    @Test
    public void testTotalThreeMonthsRewardpoints_ValidRetailer() throws RewardException {
        Integer RetailerId = 1;

        List<Retailer> transactions=new ArrayList<>();

        Retailer R1=new Retailer();
        R1.setRetailerId(RetailerId);
        R1.setTransactionDate(LocalDate.now().minusMonths(1));
        R1.setAmount(120);
        transactions.add(R1);

        Retailer R2=new Retailer();
        R2.setRetailerId(RetailerId);
        R2.setTransactionDate(LocalDate.now().minusMonths(2));
        R2.setAmount(70);
        transactions.add(R2);

        Retailer R3=new Retailer();
        R3.setRetailerId(RetailerId);
        R3.setTransactionDate(LocalDate.now().minusMonths(4));
        R3.setAmount(70);
        transactions.add(R3);

        Mockito.when(repository.findByRetailerId(RetailerId)).thenReturn(transactions);

        String result = rewardService.getRewardPointsForLastThreeMonths(RetailerId);
        Assertions.assertEquals("The retailer 1  earned the points 110", result);
    }


    @Test
    public void testTotalThreeMonthsRewardpoints_NullCustomerId() throws RewardException {
        String result = rewardService.getRewardPointsForLastThreeMonths(null);
        Assertions.  assertEquals("The Retailer ID is missing.", result);
    }

    @Test
    public void testCalculatePoints_Between50And100() {
        int points = rewardService.calculatePoints(70);
        Assertions.assertEquals(20, points);
    }


    @Test
    public void testCalculatePoints_GreaterThan100() {
        int points = rewardService.calculatePoints(120);
        Assertions.assertEquals(90, points);
    }

}
