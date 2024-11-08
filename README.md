# BankApp - A Simple Banking Application

## Overview

BankApp is a simple banking application built using **Spring Boot** and **Thymeleaf**. The app provides basic banking functionalities such as account registration, deposits, withdrawals, transfers, and viewing transaction history. It leverages **Spring Security** for user authentication and ensures that only authenticated users can access sensitive data.

## Features

- **User Registration**: Allows new users to register with a username and password.
- **Login**: Users can log in using their credentials.
- **Dashboard**: Displays account details and current balance after the user logs in.
- **Deposit**: Users can deposit funds into their account.
- **Withdraw**: Users can withdraw funds from their account with error handling for insufficient balance.
- **Transaction History**: Displays a list of transactions for the authenticated user.
- **Transfer Funds**: Users can transfer money to other users' accounts within the application.

## Prerequisites

Before running the application, ensure you have the following tools installed:

- **Java 11 or higher**
- **Maven** (for building the project)
- **Spring Boot** (used in the project)
- **MySQL** (or any other database; configuration should be adjusted accordingly)

