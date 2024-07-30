package coding.interview.algorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static final Map<Integer, Integer> map = new HashMap<>();
    private static final int[] arr = new int[100];

    private static int usingMap(int n){
        if(n <= 1){
            return n;
        }else if(map.containsKey(n)){
            return map.get(n);
        }else{
            int result = usingMap(n - 1) + usingMap(n -2);
            map.put(n, result);
            return result;
        }
    }

    private static int usingArr(int n){
        if(n <= 1){
            return n;
        }else if(arr[n] != 0){
            return arr[n];
        }else{
            arr[n] = usingArr(n-1) + usingArr(n-2);
            return arr[n];
        }
    }

    public static void main(String[] args){
        System.out.println("usingMap() = " + usingMap(9));
        System.out.println("usingArr() = " + usingArr(9));
    }
}
