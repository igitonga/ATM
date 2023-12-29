package com.company;
import java.util.Scanner;

public class Deposit {

    static int depoAmt = 0;
    static int confirm;
    static int newBalance;
    static Scanner scanner = new Scanner(System.in);
    Main main = new Main();
    public void deposit(){
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
                main.menu();
        }
    }

    public void depositSuccess(){
        newBalance = main.balance + depoAmt;

        System.out.println("=============Gee Bank=============");
        System.out.println("Name: "+main.name);
        System.out.println("Account number: 01937772410");
        System.out.println("Amount deposited: Ksh."+depoAmt);
        System.out.println("Balance: Ksh."+newBalance);
        System.out.println("Date and time: "+main.dtf.format(main.now));
        System.out.println("===========Thank you for banking with us==========");
    }
}
