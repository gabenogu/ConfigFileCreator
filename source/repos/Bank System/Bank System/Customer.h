#pragma once
#ifndef CUSTOMER_H
#define CUSTOMER_H

#include <string>
#include <vector>
#include "Account.h"

using namespace std;
class Customer 
{
	string customerID;
	string personName;
	string address;
	string phoneNumber;
	string email;
public:
	Customer(string custID, string name, string custAddress, string phoneNum, string custEmail);
	void addAccount(const Account& account);
	const vector<Account>& getAccount();
	void updateContactInfo(string& newAddress, string& newPhone);
	void displayCustomerDetails();

};

#endif

