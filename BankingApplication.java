package javaprogram;
import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		do
		{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username:");
		String name = sc.next();
		System.out.println("Enter Pin number:");
		int pin = sc.nextInt();
		BankAccount bank = new BankAccount(name,pin);
		bank.showMenu();
		
		}while(true);
		
	}

}
class BankAccount{
	int previousTransaction;
	int balance=0;
	String customerName;
	int customerId;
	BankAccount(String cname,int cid){
		customerName = cname;
		customerId = cid;
	}
	void deposite(int amount) {
		if(amount!=0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	void withdraw(int amount) {
		if(amount!=0) {
			balance = balance - amount;
			previousTransaction = amount;
		}
	}
	void getPreviousTransaction() {
		if(previousTransaction>0) {
			System.out.println("Your previous transaction is :" + previousTransaction);
		}else if(previousTransaction <0) {
			System.out.println("Your previous transaction is :" + Math.abs(previousTransaction));
		}else {
			System.out.println("No previous transactions.");
		}
	}
	void showMenu() {
		if(customerId == 12345) {
			char option = '\0';
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Welcome " + customerName);
			System.out.println("Your customer id is " + customerId);
			
			System.out.println("1.Deposite");
			System.out.println("2.Withdraw");
			System.out.println("3.Get previous transaction");
			System.out.println("4.Check Balance");
			System.out.println("5.Exit");
			do {
				System.out.println("========================");
				System.out.println("Enter your options");
				System.out.println("========================");
				option = sc.next().charAt(0);		
				switch(option) {
					case '1':
						System.out.println("========================");
						System.out.println("Enter the amount you want to Deposite:");
						System.out.println("========================");
						int amount = sc.nextInt();
						deposite(amount);
						System.out.println();
						break;
					case '2':
						System.out.println("========================");
						System.out.println("Enter the amount you want to Withdraw:");
						System.out.println("========================");
						int amount2 = sc.nextInt();
						withdraw(amount2);
						System.out.println();
						break;
					case '3':
						System.out.println("========================");
						getPreviousTransaction();
						System.out.println("========================");
						break;
					case '4':
						System.out.println("========================");
						System.out.println("Your balance is : " + balance);
						System.out.println("========================");
						break;
					case '5':
						System.out.println("Thank You for visiting.");
						break;
					default:
						System.out.println("You have choose invalid options.");
						break;
				
				}
				}while(option != '5');
			
		}else {
			System.out.println("You are not a valid user.");
		}
	}
	
}
