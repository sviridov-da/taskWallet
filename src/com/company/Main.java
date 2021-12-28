package com.company;

public class Main {

    public static void main(String[] args) {
        Wallet wallet = new Wallet(1,4,5);
        System.out.println(wallet.getCountOfPaymentMethods(13));
        System.out.println(wallet.getMinPossibleCoins(13));
    }
}
