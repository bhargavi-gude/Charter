package com.example.demo.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.Service.RewardService;


@SpringBootTest
class RewardControllerTest {

    @InjectMocks
    private RewardController rewardController;

    @Mock
    private RewardService rewardService;
    
    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

     @Test
        void testGetRewards_NullRetailerId() {
            ResponseEntity<String> response = rewardController.getRewards(null);
     
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
            assertThat(response.getBody()).isEqualTo("Invalid retailerId");
        }
     
        @Test
        void testGetRewards_InvalidRetailerId() {
            Integer invalidRetailerId = 999;
            when(rewardService.getRewardPointsForLastThreeMonths(invalidRetailerId))
                    .thenThrow(new RuntimeException("Retailer not found"));
     
            try {
                rewardController.getRewards(invalidRetailerId);
            } catch (RuntimeException ex) {
                assertThat(ex.getMessage()).isEqualTo("Retailer not found");
            }
        }
       
        @Test
        void testGetRewards_ValidRetailerId() {
            Integer validRetailerId = 1;
            when(rewardService.getRewardPointsForLastThreeMonths(validRetailerId))
                    .thenReturn("120");
     
            ResponseEntity<String> response = rewardController.getRewards(validRetailerId);
     
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
            assertThat(response.getBody()).isEqualTo("120");
        }

}