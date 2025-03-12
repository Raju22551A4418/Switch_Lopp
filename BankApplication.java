package loops;

import java.util.Scanner;

public class BankApplication {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int ch;
		int balance = 3000;
		int pin = 0000;
		do {
			System.out.println("Enter your Choice:");
			displayMenu();
			ch = Integer.parseInt(scr.next());
			switch (ch) {
			case 1:
				CheckBalance(balance);
				break;
			case 2:
				balance = DepositAmount(balance);
				break;
			case 3:
				balance = WithdrawalAmount(balance,pin);
				break;
			case 4:
				pin = PinGenerate(pin);
				break;
			case 5:
				PrintReceipt(balance);
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("Invaild Operation");
				break;
			}
		} while (ch >= 0);
		scr.close();
	}

	private static int PinGenerate(int pin) {
		Scanner scr1 = new Scanner(System.in);
		System.out.println("Enter 4 Digit Pin:");
		int fourDigitPin = scr1.nextInt();
		System.out.println("Generating Pin");
		pin = fourDigitPin;
		System.out.println("Pin Changed Successfully");
		return pin;
	}

	private static void PrintReceipt(int balance) {
		System.out.println("\n======= ATM RECEIPT =======");
		System.out.println("Date:01/01/2025 Time:11:05");
		System.out.println("Available Balance: ₹" + balance);
		System.out.println("            SBI             ");
		System.out.println("===========================\n");
	}

	private static int WithdrawalAmount(int balance,int pin) {
		Scanner scr1 = new Scanner(System.in);
		System.out.println("Enter Withdrawal Amount:");
		int withdraw = scr1.nextInt();
		System.out.println("Enter Your Pin:");
		int pinNo=scr1.nextInt();
		if(pinNo == pin) {
			if (withdraw > balance) {
				System.out.println("Insufficient Funds");
				return balance;
			} else {
				System.out.println("Withdrawal Amount is: ₹" + withdraw);
				balance -= withdraw;
				System.out.println("Available Balance: ₹" + balance);
				return balance;
			}
		}else {
			System.out.println("Wrong Pin Please Provide Correct Pin");
		}
		return pin;
		
	}

	private static int DepositAmount(int balance) {
		Scanner scr1 = new Scanner(System.in);
		System.out.println("Enter Deposit Amount:");
		int deposit = scr1.nextInt();
		System.out.println("Depositing Amount is: ₹" + deposit);
		balance = balance + deposit;
		System.out.println("Available Balance: ₹" + balance);
		return balance;
	}

	private static void CheckBalance(int balance) {
		System.out.println("Current Balance: ₹" + balance);
	}

	private static void displayMenu() {
		System.out.println("\t1.Check Balance");
		System.out.println("\t2.Deposit Amount");
		System.out.println("\t3.Withdraw Amount");
		System.out.println("\t4.Generate Pin");
		System.out.println("\t5.Print Receipt");
		System.out.println("\t6.Exit");
	}
}
