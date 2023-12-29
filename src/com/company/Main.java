package com.company;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {

    static String name;
    static int balance = 200000;
    static int securityPin = 2089;
    static int menu;
    static Scanner scanner = new Scanner(System.in);
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

    static void welcome(){
        System.out.println("Hello, welcome to Gee Bank");
        System.out.println("Please enter your name");
        name = scanner.nextLine();

        security();
    }

    static void security(){
        int maxAttempts = 3;

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println("Enter your 4-digit pin");
            int pin = scanner.nextInt();

            if (pin == securityPin) {
                menu();
                return;  // Exit the method if the pin is correct
            } else {
                System.out.println("Incorrect pin. Try again.");
            }
        }

        System.out.println("Out of tries. Security timeout.");
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
                Balance balanceInst = new Balance();
                balanceInst.balance();
                break;

            case 2:
                Withdraw withdrawInst = new Withdraw();
                withdrawInst.withdraw();
                break;

            case 3:
                Deposit depositInst = new Deposit();
                depositInst.deposit();
                break;

            default:
                System.out.println("Unknown choice");
                menu();
                break;
        }
    }

    public static void main(String[] args) {
        welcome();
    }
}
