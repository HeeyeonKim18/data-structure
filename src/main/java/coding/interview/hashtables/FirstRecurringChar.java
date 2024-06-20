package coding.interview.hashtables;

import java.util.HashMap;
import java.util.HashSet;

public class FirstRecurringChar {
    static int result = -1;
    static int findOut1(int[] arr){   // O(n^2)
        for(int i = 1; i < arr.length - 1; i++){
            for(int j = i - 1; j >= 0; j--){
                if(arr[i] == arr[j]){
                    result = arr[i];
                    return result;
                }
            }
        }
        return result;
    }

    static int findOut2(int[] arr){
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            if(set.contains(arr[i])){
                result = arr[i];
                return result;
            }
            set.add(arr[i]);
        }
        return result;
    }

    static int findOut3(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                result = arr[i];
                return result;
            }
            map.put(arr[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,5,5,2,3,5,1,2,4};
        System.out.println(findOut1(arr));
        System.out.println(findOut2(arr));
        System.out.println(findOut3(arr));
    }
}
