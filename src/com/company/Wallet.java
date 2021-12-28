package com.company;

import java.util.*;

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

    public List<Integer> getMinPossibleCoins(int resultSum){
        int[] tmpResults = new int[resultSum+1];
        List<Integer>[] currentCoins = new List[resultSum+1];
        tmpResults[0] = 0;
        currentCoins[0] = new ArrayList<>();
        for(int i = 1; i<tmpResults.length; i++){
            currentCoins[i] = new ArrayList<>();
            for(int coin : coins){
                if(i-coin>=0 && (tmpResults[i]==0 || (tmpResults[i]>tmpResults[i-coin]+1))){
                    currentCoins[i] = new ArrayList<>(currentCoins[i-coin]);
                    currentCoins[i].add(coin);
                    tmpResults[i] = tmpResults[i-coin]+1;
                }
            }
        }
        return currentCoins[resultSum];
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
