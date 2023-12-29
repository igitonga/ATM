package com.company;

public class Balance {

    public void balance(){
        Main mainInst = new Main();
        System.out.println("=============Gee Bank=============");
        System.out.println("Name: "+mainInst.name);
        System.out.println("Account number: 01937772410");
        System.out.println("Amount available: Ksh."+mainInst.balance);
        System.out.println("Date and time: "+mainInst.dtf.format(mainInst.now));
        System.out.println("===========Thank you for banking with us==========");
    }

}
