//Name: Jarly Williams
//Course: CIS 3110
//Date: 11/30/16
//Homework #5
//Purpose: simulate banking transactions

#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
using namespace std;

//declare nested structs to hold fields for BankAccount 

//struct Name holds fields for Depositor's name
struct Name
{
	string firstname = "";
	string lastname = "";
};

//struct Depositor holds fields for depositor information
struct Depositor
{
	Name name;
	string ssn = "";
};

//holds all information relating to a bank account
struct BankAccount
{
	Depositor depositor;
	int accountnum = 0;
	string accounttype = "";
	double balance = 0;
};


//prototypes:

//Purpose: opens the files to be written to
//Requires: none
//Returns: none, the file stream is opened
void openFiles(ofstream & outfile);

//Purpose: prints the headings for the program
//Requires: the outfile stream
//Returns: none
void printHeadings(ofstream & outfile);

//Purpose: prints the closing messages
//Requires: the outfile stream
//Returns: none
void printEndMessage(ofstream & outfile);

//Purpose: displays the menu for the user
//Requires: none
//Returns: none
void menu();

//Purpose: populates the array with accounts
//Requires: array of accounts, maximum number of accounts
//Returns: the number of accounts in the array
int read_accts(BankAccount account[], int max_accts);

//Purpose: locates a bank account in the array
//Requires: the array of accounts, the number of accounts, account to look for
//Returns: the index of the requested account
int findacct(const BankAccount account[], int num_accts, 
	int requested_account);

//Purpose: locates a bank account in the array by searching for the ssn
//Requires: the array of accounts, the number of accounts, ssn to look for
//Returns: the index of the requested account
int searchSSN(const BankAccount account[], int num_accts,
	string accountssn);

//Purpose: withdraws an amount of money from an account
//Requires: the array of accounts, number of accounts
//Returns: none
void withdrawal(BankAccount account[], int num_accts);

//Purpose: deposits an amount of money into an account
//Requires: the array of accounts, number of accounts
//Returns: none
void deposit(BankAccount account[], int num_accts);

//Purpose: opens a new account
//Requires: the array of accounts, number of accounts
//Returns: new number of accounts in the array
int new_acct(BankAccount account[], int num_accts, int max_accts);

//Purpose: closes an account
//Requires: the array of accounts, the number of accounts
//Returns: the new number of accounts
int close_acct(BankAccount account[], int num_accts);

//Purpose: displays the balance of an account
//Requires: the array of accounts, the number of accounts, output stream
//Returns: none
void balance(const BankAccount account[], int num_accts, ofstream & outfile);

//Purpose: displays the ssn of an account
//Requires: array of accounts, the number of accounts, output stream
//Returns: none
void account_info(const BankAccount account[], int num_accts,
	ofstream & outfile);

//Purpose: displays full account information of all accounts
//Requires: the array of accounts, number of accounts, output stream
//Returns: none
void print_accts(const BankAccount account[], int num_accts,
	ofstream & outfile);

void main()
{
	//declare integer to hold the array size
	const int MAXSIZE = 2;
	ofstream outfile; //output stream
	BankAccount account[MAXSIZE]; //array of nested structs
	int numaccounts = 0;
	char input = 0;

	openFiles(outfile);
	printHeadings(outfile);

	numaccounts = read_accts(account, MAXSIZE);
	print_accts(account, numaccounts, outfile);

	//do while loop to keep displaying menu until user quits
	do
	{
		menu();
		cin >> input; //gets user menu selection

		switch (input)
		{
			case 'W':
				withdrawal(account, numaccounts);
			break;
			case 'D':
				deposit(account, numaccounts);
			break;
			case 'N':
				numaccounts = new_acct(account, numaccounts, MAXSIZE);
			break;
			case 'B':
				balance(account, numaccounts, outfile);
			break;
			case 'I':
				account_info(account, numaccounts, outfile);
			break;
			case 'C':
				numaccounts = close_acct(account, numaccounts);
			break;
			case 'Q':
				//prints out accounts
				print_accts(account, numaccounts, outfile);
				input = 'X';
			break;
			default:
				cout << ("Unknown selection") << endl;
			break;
		}
	} while (input != 'X'); //leaves loop when user chooses to quit

}

void openFiles(ofstream & outfile)
{
	char outfileName[20];

	//opens file to be written to.
	cout << "Please enter name of output file: ";
	cin >> outfileName;
	outfile.open(outfileName);
}

void printHeadings(ofstream & outfile)
{
	//print header information
	cout << "Name : Jaryl Williams" << endl;
	cout << "Course: CIS 3110" << endl;
	cout << "Homework #5" << endl;
	cout << "November, 30, 2016" << endl;
	cout << "Purpose: simulate banking transactions" << endl << endl << endl;
}

int read_accts(BankAccount account[], int max_accts)
{
	int numaccts = 0;
	
	cout << "Enter number of accounts desired: ";
	cin >> numaccts;

	while (numaccts > max_accts)
	{
		cout << "Please enter a number less than " << max_accts << " :";
		cin >> numaccts;
	}
	

	//populate array
	for (int i = 0; i < max_accts; i++)
	{
		cout << "Enter account holder first name: ";
		cin >> account[i].depositor.name.firstname;
		cout << "Enter account holder last name: ";
		cin >> account[i].depositor.name.lastname;
		cout << "Enter account holder SSN: ";
		cin >> account[i].depositor.ssn;
		cout << "Enter account type: ";
		cin >> account[i].accounttype;
		cout << "Enter account number: ";
		cin >> account[i].accountnum;
		cout << "Enter account balance: $";
		cin >> account[i].balance;
		cout << endl << endl;
	}
	return numaccts;
}

void menu()
{
	cout << "Select one of the following: " << endl;
	cout << "\tW - Withdrawal" << endl;
	cout << "\tD - Deposit" << endl;
	cout << "\tN - New Account" << endl;
	cout << "\tB - Balance" << endl;
	cout << "\tI - Account Info" << endl;
	cout << "\tC - Close Account" << endl;
	cout << "\tQ - Quit" << endl;
}

int findacct(const BankAccount account[], int num_accts, int requested_account)
{
	//loop through array to find account number
	for (int i = 0; i < num_accts; i++)
	{
		//if account number was found
		if (account[i].accountnum == requested_account)
		{
			return i; //index of correct account in the array
		}
	}
	//if not found, return -1
	return -1;
}

int searchSSN(const BankAccount account[], int num_accts,
	string accountssn)
{
	//loop through array to find ssn
	for (int i = 0; i < num_accts; i++)
	{
		//if account holder ssn was found
		if (account[i].depositor.ssn == accountssn)
		{
			return i; //index of correct account in the array
		}
	}
	//if not found, return -1
	return -1;
}

void withdrawal(BankAccount account[], int num_accts)
{
	int accountnumber = 0;
	int index = 0;
	double amount = 0;

	//gets account number from user
	cout << "Enter account number: ";
	cin >> accountnumber;

	//set index to index of found account number in array
	index = findacct(account, num_accts, accountnumber);

	//display error message if account number was not found
	if (index == -1)
	{
		cout << "Account " << accountnumber << " does not exist." << endl;
		return;
	}

	cout << "Enter amount to withdraw: ";
	cin >> amount;

	//check to see if there is sufficient funds in account
	if (account[index].balance < amount)
	{
		cout << "Insufficient funds to complete transaction." << endl;
	}

	//perform withdrawal
	account[index].balance -= amount;
}

void deposit(BankAccount account[], int num_accts)
{
	int accountnumber = 0;
	int index = 0;
	double amount = 0;

	//gets account number from user
	cout << "Enter account number: ";
	cin >> accountnumber;

	//set index to index of found account number in array
	index = findacct(account, num_accts, accountnumber);

	//display error message if account number was not found
	if (index == -1)
	{
		cout << "Account " << accountnumber << " does not exist." << endl;
		return;
	}

	cout << "Enter amount to deposit: ";
	cin >> amount;

	//perform deposit
	account[index].balance += amount;
}

int new_acct(BankAccount account[], int num_accts, int max_accts)
{
	int accountnumber = 0;
	int index = 0;

	//gets account number from user
	cout << "Enter account number: ";
	cin >> accountnumber;

	//set index to index of found account number in array
	index = findacct(account, num_accts, accountnumber);

	//display error message if account number was found
	if (index != -1)
	{
		cout << "Account " << accountnumber << " already exists." << endl;
		return num_accts;
	}

	//check to see if a new account would go outside array bounds
	if (num_accts + 1 == max_accts)
	{
		cout << "The bank has too many accounts." << endl;
		return num_accts;
	}

	//else create the new account
	cout << "Enter account holder first name: ";
	cin >> account[num_accts].depositor.name.firstname;
	cout << "Enter account holder last name: ";
	cin >> account[num_accts].depositor.name.lastname;
	cout << "Enter account holder SSN: ";
	cin >> account[num_accts].depositor.ssn;
	cout << "Enter account type: ";
	cin >> account[num_accts].accounttype;
	account[num_accts].accountnum = accountnumber;
	cout << "Enter account balance: $";
	cin >> account[num_accts].balance;

	return num_accts + 1;
}

void balance(const BankAccount account[], int num_accts, ofstream & outfile)
{
	int accountnumber = 0;
	int index = 0;

	//gets account number from user
	cout << "Enter account number: ";
	cin >> accountnumber;

	//set index to index of found account number in array
	index = findacct(account, num_accts, accountnumber);

	//display error message if account number was found
	if (index == -1)
	{
		cout << "Account " << accountnumber << " does not exist." << endl;
		return;
	}

	outfile << "Account Balance: $" << fixed << setprecision(2)
		<< account[index].balance << endl;
}

void account_info(const BankAccount account[], int num_accts,
	ofstream & outfile)
{
	string accountssn = "";
	int index = 0;

	//gets account number from user
	cout << "Enter account holder's ssn: ";
	cin >> accountssn;

	//set index to index of found account number in array
	index = searchSSN(account, num_accts, accountssn);

	//display error message if account number was found
	if (index == -1)
	{
		cout << "The SSN: " << accountssn << " is not linked to any account." 
		<< endl;
		return;
	}

	outfile << "Account Holder Name: "
		<< account[index].depositor.name.firstname << " "
		<< account[index].depositor.name.lastname << endl;
	outfile << "Account Holder SSN: " << account[index].depositor.ssn << endl;
	outfile << "Account Type: " << account[index].accounttype << endl;
	outfile << "Account Number: " << account[index].accountnum << endl;
	outfile << "Account Balance: $" << fixed << setprecision(2)
		<< account[index].balance << endl;
}

int close_acct(BankAccount account[], int num_accts)
{
	int accountnumber = 0;
	int index = 0;

	//gets account number from user
	cout << "Enter account number: ";
	cin >> accountnumber;

	//set index to index of found account number in array
	index = findacct(account, num_accts, accountnumber);

	//display error message if account number was found
	if (index == -1)
	{
		cout << "Account " << accountnumber << " does not exist." << endl;
		return num_accts;
	}

	//shift elements to right of index to the left to delete element[index]
	for (int i = index; i < num_accts - 1; i++)
	{
		account[i] = account[i + 1];
	}

	return num_accts - 1;
}

void print_accts(const BankAccount account[], int num_accts,
	ofstream & outfile)
{
	if (num_accts > 0)
	{
		//create table headings
		outfile << "Name" << "                " << "   SSN"
			<< "              "
			<< "   Account Type" << "            " << "   Account Number"
			<< "            " << "   Account Balance" << endl;
		for (int i = 0; i < num_accts; i++)
		{
			outfile << account[i].depositor.name.firstname << " "
				<< account[i].depositor.name.lastname << "       "
				<< account[i].depositor.ssn << "              "
				<< account[i].accounttype << "                   "
				<< account[i].accountnum << "                            "
				<< fixed << setprecision(2) << "$" << account[i].balance
				<< endl << endl;
		}
	}
	else
	{
		outfile << endl << endl;
		outfile << "There are no accounts in this bank. Create New Accounts."
			<< endl;
	}
}



