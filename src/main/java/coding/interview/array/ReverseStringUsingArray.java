package coding.interview.array;

import java.util.ArrayList;

// Create a function that reverses a String:
// 'Hi My name is Heeyeon' should be:
// 'noeyeeH si eman yM iH'
public class ReverseStringUsingArray {

    static char[] arr;

    public static String reverse(String content){
        int totalItems = content.length();
        arr = new char[totalItems];
        int index = 0;
        for (int i = totalItems - 1; i >= 0; i--) {
            arr[index++] = content.charAt(i);
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            str.append(arr[i]);
        }
        return str.toString();
    }
    public static void main(String[] args) {
        String str = "Hi My name is Heeyeon";

        String reverseStr = reverse(str);
        System.out.println("reverseStr = " + reverseStr);
    }
}
