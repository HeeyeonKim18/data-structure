package coding.interview.data.array;

import java.util.HashSet;
import java.util.Set;

public class HasPairWithSum {
    public static boolean hasPair(int[] arr, int sum){
        int length = arr.length;

        for(int i = 0; i < length-1; i++){
            for(int j = i+1; j < length; j++){
                if(arr[i] + arr[j] == sum) return true;
            }
        }
        return false;
    }

    public static boolean hasPair2(int[] arr, int sum){
        Set<Integer> set = new HashSet<>();
        int length = arr.length;
        for(int i : arr){
            if(set.contains(arr[i])) return true;
            set.add(sum - arr[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,9};
        int[] arr2 = {2,3,4,4};
        int sum = 8;
        System.out.println(hasPair2(arr2, sum));
    }
}
