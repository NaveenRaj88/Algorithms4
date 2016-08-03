package com.chap2.sec_2_4;

/**
 * Created by Naveen Kumar .A on 8/1/16.
 */
public class MinPQ {

    enum Offer{
        CONDITIONAL_DISCOUNT ("conditionalDiscount", 1, "", true);

         int multiplier;

         String id;

         String sign;

         boolean usedForPriceCalculation;

        private  Offer(String id, int multiply, String sign, boolean usedForPriceCalculation) {
            this.id = id;
            multiplier = multiply;
            this.sign = sign;
            this.usedForPriceCalculation = usedForPriceCalculation;
        }
    }
    public static void main(String[] args) {
        System.out.println(Offer.CONDITIONAL_DISCOUNT.name());
    }
}
