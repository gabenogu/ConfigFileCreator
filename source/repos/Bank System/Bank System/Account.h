#ifndef ACCOUNT_H
#define ACCOUNT_H

#include <string>
using namespace std;
class Account {
	string accountNumber;
	double balance;
	string accountType;

public:
	Account(string accountNumber, double balance, string accountType);
	void deposit(double amount);
	bool withdraw(double amount);
	double getBalance() const;
	bool transferFunds(Account acc, double amount);
	void displayAccDetails();
};