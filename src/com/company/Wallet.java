package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Wallet {
    HashSet<Integer> coins;
    int maxCoin;
    public Wallet(int... coins){
        this.coins = new HashSet<Integer>(); //чтобы исключить повторения номиналов
        for(int coin : coins){
            if (coin<1){
                throw new RuntimeException("Negative nominal of coin");//ошибка отрицательных и нулевых номиналов
            }
            this.coins.add(coin);
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
