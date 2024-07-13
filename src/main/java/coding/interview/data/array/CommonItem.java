package coding.interview.data.array;
import java.util.*;

public class CommonItem {
    public static void main(String[] args) {
        String[] array1 = {"a", "b", "c", "x"};
        String[] array2 = {"z", "y", "a"};

        System.out.println(containsCommonItem2(array1, array2));
    }
    public static boolean containsCommonItem1(String[] arr1, String[] arr2) {
        // loop through first array and create object where properties === items in the array
        // can we assume always 2 params?

        HashMap<String, Boolean> map = new HashMap<>();
        for(int i = 0; i < arr1.length; i++){
            if(!map.containsKey(arr1[i])){
                String item = arr1[i];
                map.put(item, true);
            }
        }

        // loop through second array and check if item in second array exists on created object.
        for(int j = 0; j < arr2.length; j++){
            if(map.containsKey(arr2[j])){
                return true;
            }
        }
        return false;
    }

    public static boolean containsCommonItem2(String[] arr1, String[] arr2){
        Set<String> set1 = new HashSet<>(Arrays.asList(arr1));
        Set<String> set2 = new HashSet<>(Arrays.asList(arr2));
        return !Collections.disjoint(set1, set2);
    }
}


