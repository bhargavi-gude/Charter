package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.RewardService;

@RestController
@RequestMapping(value = "/api")
public class RewardController {
	
    @Autowired
    private RewardService rewardService;

    @GetMapping(value= "/retailer/{retailerId}")
    public ResponseEntity<String> getRewards(@PathVariable("retailerId") Integer retailerId) {
        if (retailerId == null) {
            return new ResponseEntity<>("Invalid retailerId", HttpStatus.BAD_REQUEST);
        }

        String points = rewardService.getRewardPointsForLastThreeMonths(retailerId);
        return new ResponseEntity<>(points, HttpStatus.OK);
 }

}