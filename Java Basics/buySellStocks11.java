import java.util.*;

public class buySellStocks11 {
    static void buySell(int [] stocks){
        int max = Integer.MIN_VALUE;
        int buyPrice = stocks[0],profit=0;


        // for (int i = 1; i < stocks.length; i++) {
        //     if (buyPrice>stocks[i]) {
        //         buyPrice=stocks[i];
        //     }
        //     profit = stocks[i]-buyPrice;
        //     if (profit>max) {
        //         max=profit;
        //     }

        // }
        // System.out.println(max<0?0:max);
        
        for (int i = 0; i < stocks.length; i++) {
            if (buyPrice<stocks[i]) {
                profit = stocks[i]-buyPrice;
                max = Math.max(max, profit);
            }else{
                buyPrice = stocks[i];
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        int stocks[] = {7,1,5,3,6,4};
        buySell(stocks);
    }
}
