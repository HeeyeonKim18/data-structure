# Dynamic Programming

- It is an optimization technique
- Breaking it down into a collection of subproblems
- Storing their solutions in case next time the same subproblem occurs = “Remember your Past”
- Divide & conquer + Memoization
- Tabulation(bottom up) vs Memoization(top down)

Dynamic Programming is mainly an optimization over plain recursion. Wherever we see a recursive solution that has repeated calls for the same inputs, we can optimize it using Dynamic Programming. The idea is to simply store the results of subproblems so that we do not have to re-compute them when needed later. This simple optimization reduces time complexities from exponential to polynomial.

---

### Steps

if a problem can use dynamic programming to optimize

1. Can be divided into subproblem
2. Recursive solution
3. Are there repetitive subproblems?
4. Memoize subproblems
5. Demand a raise from your boss

---

### Dynamic programming VS recursion?

In dynamic programming, problems are solved by breaking them down into smaller ones to solve the larger ones, while recursion is when a function is called and executed by itself. 

Using dynamic programming, you can break a problem into smaller parts, called subproblems, to solve it. Dynamic programming involves solving the problem for the first time, then using memoization to store the solutions.

Therefore, the main difference between the two techniques is their intended use; recursion is used to automate a function, whereas dynamic programming is an optimization technique used to solve problems.

---

### Coding Test

- https://leetcode.com/problems/house-robber/description/
    
    ```java
    public class Robber {
        public int rob(int[] nums) {
            int[] arr = new int[nums.length];
    
            if(nums.length == 1) return nums[0];
    
            arr[0] = nums[0];
            arr[1] = Math.max(nums[0], nums[1]);
    
            if(nums.length > 2){
                for(int i = 2; i < nums.length; i++){
                    arr[i] = Math.max(arr[i-1], arr[i-2] + nums[i]);
                }
            }
    
            return arr[nums.length - 1];
        }
    }
    ```
    
- https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    
    ```java
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
    }
    ```
    
- https://leetcode.com/problems/climbing-stairs/description/
    
    ```java
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
    }
    ```