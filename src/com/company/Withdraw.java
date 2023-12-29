package com.company;

import java.util.Scanner;

public class Withdraw {
    static int amtWithdraw;
    static int newBalance;
    static int confirm;
    static Scanner scanner = new Scanner(System.in);
    Main main = new Main();
    public void withdraw(){
        System.out.println("How much would you like to withdraw?");
        amtWithdraw = scanner.nextInt();
        if(amtWithdraw >= main.balance){
            System.out.println("Insufficient funds");
            main.menu();
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
                    main.menu();
            }
        }
    }


    public void withdrawalSuccess(){
        newBalance = main.balance - amtWithdraw;

        System.out.println("=============Gee Bank=============");
        System.out.println("Name: "+main.name);
        System.out.println("Account number: 01937772410");
        System.out.println("Amount withdrawn: Ksh."+amtWithdraw);
        System.out.println("Balance: Ksh."+newBalance);
        System.out.println("Date and time: "+main.dtf.format(main.now));
        System.out.println("===========Thank you for banking with us==========");
    }
}
