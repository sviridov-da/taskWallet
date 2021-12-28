package com.company;

import java.util.Arrays;

public class Wallet {
    int[] coins;
    int maxCoin;
    public Wallet(int... coins){
        this.coins = coins.clone();
        maxCoin = Integer.MIN_VALUE;
        for(int coin : this.coins){
            if(coin>maxCoin){
                maxCoin = coin;
            }
        }
    }

    public int getCountOfPaymentMethods(int resultSum){
        return getTmpResultFor(resultSum, maxCoin);
    }

    private int getTmpResultFor(int targetIndex, int maxCoin){
        int[] tmpResults = new int[targetIndex+1];
        tmpResults[0]=1;
        for(int coin : coins) {
            if (targetIndex - coin >= 0 && coin<=maxCoin) {
                tmpResults[targetIndex] += getTmpResultFor(targetIndex - coin, coin);
            }
        }
        return tmpResults[targetIndex];
    }
}
