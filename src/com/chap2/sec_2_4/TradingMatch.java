package com.chap2.sec_2_4;

public class TradingMatch {
    static final int  BUY = 0, SELL = 1, mod = 1000000007;


    public int getNumberOfBacklogOrders(int[][] orders){
            return 0;
    }

}

class Order implements Comparable<Order>{
    int price, amount, orderType;

    public Order (int price, int amount, int orderType){
        this.price = price;
        this.amount = amount;
        this.orderType = orderType;
    }
    public int compareTo(Order o){
        return this.price - o.price;
    }


}
