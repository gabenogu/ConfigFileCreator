#include "Account.h"
#pragma once
#include<string>
#include<iostream>

using namespace std;
class Account
{
	string accountNumber;
	double balance;
	string accountType;
public:
	Account(string accountNumber, double balance, string accountType) {
		this->accountNumber = accountNumber;
		this->balance = balance;
		this->accountType = accountType;
	}
	void deposit(double amount) {
		balance += amount;
		cout << "Deposited $" << amount << ". New balance is $" << amount << endl;
	}
	bool withdraw(double amount) {
		if (amount > balance) {
			cout << "Not enough funds to withdraw" << endl;
			return false;
		}
		else {
			balance -= amount;
			cout << "Withdrew $" << amount << ". New balance is $" << amount << endl;
			return true;
		}
	}
	double getBalance() const {
		return balance;
	}
	bool transferFunds(Account acc, double amount) {
		if (withdraw(amount)) {
			acc.deposit(amount);
			cout << "Transfering $" << amount << " to " << acc.accountNumber << endl;
		}

	}
	void displayAccDetails() const{
		cout << "Account Number: " << accountNumber << ", Account Type: " << accountType << ", Account Balance: $" << balance << endl;
	}
};

