package coding.interview.algorithm.dynamicprogramming;

// leetCode
// 121. Best Time to Buy and Sell Stock
public class Profit {

    // my solution
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] arr = new int[length];

        arr[0] = 0;
        int point = 0;
        for (int i = 1; i < length; i++) {
            arr[i] = Math.max(arr[i - 1], prices[i] - prices[point]);
            point = prices[point] < prices[i] ? point : i;
        }

        return arr[length - 1];
    }

    // other solution
    public int findProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }

            profit = Math.max(profit, prices[i] - buyPrice);
        }

        return profit;
    }

    public static void main(String[] args) {
        Profit profit = new Profit();
        System.out.println("profit.maxProfit() = " + profit.maxProfit(new int[]{3, 5, 2, 1, 53, 6, 73, 0, 99}));
        System.out.println("profit.findProfit() = " + profit.findProfit(new int[]{3, 5, 2, 1, 53, 6, 73, 0, 99}));
    }
}
