package coding.interview.algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

// leetCode
// 70. Climbing Stairs
public class Stair {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];

        if (n <= 2) {
            return n;
        } else {
            arr[1] = 1;
            arr[2] = 2;
            for (int i = 3; i < arr.length; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[n];
        }
    }

    public int recursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return recursion(n-1) + recursion(n-2);
    }

    public int memoization(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        Stair stair = new Stair();
        System.out.println("stair.climbStairs(5) = " + stair.climbStairs(5));
        System.out.println("stair.recursion(5) = " + stair.recursion(5));
        System.out.println("stair.memoization(5) = " + stair.memoization(5));
    }
}
