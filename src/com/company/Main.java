package com.company;
import java.util.Scanner;

public class Main {

    static String name;
    static String amount;
    static int balance = 200000;
    static int securityPin = 2089;
    static int pin;
    static int menu;
    static int amtWithdraw;
    static int newBalance;
    static int confirm;

    static Scanner scanner = new Scanner(System.in);

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
        menu = scanner.nextInt();
        switch (menu){
            case 1:
                balance();
                break;

            case 2:
                withdraw();
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
                    success();
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
        System.out.println("Amount available: "+balance);
        System.out.println("===========Thank you for banking with us==========");
    }

    static void success(){
        newBalance = balance - amtWithdraw;

        System.out.println("=============Gee Bank=============");
        System.out.println("Name: "+name);
        System.out.println("Account number: 01937772410");
        System.out.println("Amount withdrawn: "+amtWithdraw);
        System.out.println("Balance: "+newBalance);
        System.out.println("===========Thank you for banking with us==========");
    }

    public static void main(String[] args) {

        welcome();

        security();
    }
}
