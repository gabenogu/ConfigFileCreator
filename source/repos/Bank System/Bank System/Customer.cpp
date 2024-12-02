#include "Customer.h"
#include<iostream>
class Customer
{
	string customerID;
	string personName;
	string address;
	string phoneNumber;
	string email;
	vector<Account> accounts;

public:
	Customer(string custID, string name, string custAddress, string phoneNum, string custEmail) {
		customerID = custID;
		personName = name;
		address = custAddress;
		phoneNumber = phoneNum;
		email = custEmail;
	}
	void addAccount(const Account& account) {
		accounts.push_back(account);
		cout << "Account added for customer: " << personName << endl;
	}

	const vector<Account>& getAccount()
	{
		return accounts;
	}

	void updateContactInfo(string& newAddress, string& newPhone)
	{
		address = newAddress;
		phoneNumber = newPhone;
		cout << "Contact information updated. Your address is now " << newAddress << " and your phone number is now " << newPhone << endl;
	}

	void displayCustomerDetails() const
	{
		cout << "Here are your details: "
			<< "Customer ID is " << customerID
			<< ", Customer name is " << personName
			<< ", Customer address is " << address
			<< ", Customer number is " << phoneNumber
			<< ", Customer email is " << email << endl;
		for (auto account : accounts) {
			account.displayAccDetails();
		}
	}


	

};