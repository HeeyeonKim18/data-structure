package coding.interview.data.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MargeSortedArray {
    public static int[] margeArr1(int[] arr1, int[] arr2) {
        // using for loops(bruteforce)
        int[] margeArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            margeArr[i] = arr1[i];
        }
        int index = 0;
        for (int i = arr1.length; i < arr1.length + arr2.length; i++) {
            margeArr[i] = arr2[index++];
        }

        return Arrays.stream(margeArr).sorted().toArray();
    }

    public static ArrayList<Integer> margeArr2(int[] arr1, int[] arr2) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < arr1.length && j < arr2.length){

            if(arr1[i] < arr2[j]){
                list.add(arr1[i]);
                i++;
            }else{
                list.add(arr2[j]);
                j++;
            }
        }

        while(i < arr1.length){
            list.add(arr1[i]);
            i++;
        }

        while(j < arr2.length){
            list.add(arr2[j]);
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 3, 4, 31};
        int[] arr2 = {4, 6, 30, 45, 53};
        int[] result = margeArr1(arr1, arr2);
        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.println();

        ArrayList<Integer> listResult = margeArr2(arr1, arr2);
        for (Integer integer : listResult) {
            System.out.print(integer + " ");
        }


    }
}
