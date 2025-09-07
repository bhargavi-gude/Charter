# Rewards Program - Spring Boot Application



This is a Spring Boot project that calculates reward points for customers based on their transactions.

The project is implemented using *Java 8, **Spring Boot, and **MySQL*.



---



## Problem Statement

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase:



- *2 points* for every dollar spent over $100 in each transaction.

- *1 point* for every dollar spent between $50 and $100 in each transaction.



👉 Example: A $120 purchase = (2 x $20) + (1 x $50) = *90 points*.



The application calculates reward points for each customer per *month* and *total* over a *three-month period*.





## Technologies Used

- Java 8

- Spring Boot

- MySQL

- Maven

- REST API

- CRUD Repository

- JUNIT with MOCKITO





-->Port NO:9001



URL to get the points based on rewardId is: http://localhost:9001/api/retailer/{rewardId};