package com.company;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {

    static String name;
    static int balance = 200000;
    static int securityPin = 2089;
    static int pin;
    static int menu;
    static int amtWithdraw;
    static int newBalance;
    static int confirm;
    static int depoAmt;

    static Scanner scanner = new Scanner(System.in);
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

    static void welcome(){
        System.out.println("Hello, welcome to Gee Bank");
        System.out.println("Please enter your name");
        name = scanner.nextLine();
    }

    static void security(){
        System.out.println("Enter your 4 digit pin");
        pin = scanner.nextInt();

        if(pin != securityPin){
            System.out.println("Incorrect pin. Try again");
            pin = scanner.nextInt();

            if(pin != securityPin){
                System.out.println("Incorrect pin. Try again");
                pin = scanner.nextInt();

                if(pin != securityPin){
                    System.out.println("Out of tries. ACCOUNT BLOCKED!");
                }
            }
            else {
                menu();
            }

        }
        else {
            menu();
        }
    }

    static void menu(){
        System.out.println("Choose which action to perform");
        System.out.println("1. Check bank balance");
        System.out.println("2. Withdraw");
        //System.out.println("3. Fund transfer");
        System.out.println("3. Deposit");
        menu = scanner.nextInt();
        switch (menu){
            case 1:
                balance();
                break;

            case 2:
                withdraw();
                break;

            case 3:
                deposit();
                break;

            default:
                System.out.println("Unknown choice");
                menu();
                break;
        }
    }

    static void withdraw(){
        System.out.println("How much would you like to withdraw?");
        amtWithdraw = scanner.nextInt();
        if(amtWithdraw >= balance){
            System.out.println("Insufficient funds");
            menu();
        }
        else{
            System.out.println("Confirm that you want to withdraw "+amtWithdraw);
            System.out.println("1. Yes");
            System.out.println("2. No");
            confirm = scanner.nextInt();
            switch (confirm){
                case 1:
                    withdrawalSuccess();
                    break;

                case 2:
                    System.out.println("Withdrawal cancelled");
                    menu();
            }
        }
    }

    static  void balance(){
        System.out.println("=============Gee Bank=============");
        System.out.println("Name: "+name);
        System.out.println("Account number: 01937772410");
        System.out.println("Amount available: Ksh."+balance);
        System.out.println("Date and time: "+dtf.format(now));
        System.out.println("===========Thank you for banking with us==========");
    }

    static void deposit(){
        System.out.println("How much would you like to deposit");
        depoAmt = scanner.nextInt();
        System.out.println("Confirm that you want to deposit Ksh."+depoAmt);
        System.out.println("1. Yes");
        System.out.println("2. No");
        confirm = scanner.nextInt();
        switch (confirm){
            case 1:
                depositSuccess();
                break;

            case 2:
                System.out.println("Deposit cancelled");
                menu();
        }
    }

    static void withdrawalSuccess(){
        newBalance = balance - amtWithdraw;

        System.out.println("=============Gee Bank=============");
        System.out.println("Name: "+name);
        System.out.println("Account number: 01937772410");
        System.out.println("Amount withdrawn: Ksh."+amtWithdraw);
        System.out.println("Balance: Ksh."+newBalance);
        System.out.println("Date and time: "+dtf.format(now));
        System.out.println("===========Thank you for banking with us==========");
    }

    static void depositSuccess(){
        newBalance = balance + depoAmt;

        System.out.println("=============Gee Bank=============");
        System.out.println("Name: "+name);
        System.out.println("Account number: 01937772410");
        System.out.println("Amount deposited: Ksh."+depoAmt);
        System.out.println("Balance: Ksh."+newBalance);
        System.out.println("Date and time: "+dtf.format(now));
        System.out.println("===========Thank you for banking with us==========");
    }

    public static void main(String[] args) {

        welcome();

        security();
    }
}
