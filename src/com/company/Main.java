package com.company;

public class Main {

    public static void main(String[] args) {
        Wallet wallet = new Wallet(1,2,2,5,10);
        System.out.println(wallet.getCountOfPaymentMethods(86));
    }
}
