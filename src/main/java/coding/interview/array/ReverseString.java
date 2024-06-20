package coding.interview.array;

import java.util.ArrayList;

// Create a function that reverses a String:
// 'Hi My name is Heeyeon' should be:
// 'noeyeeH si eman yM iH'
public class ReverseString {

    static ArrayList<Character> list = new ArrayList<>();

    public static String reverse(String content){
        for (int i = content.length() - 1; i >= 0; i--) {
            list.add(content.charAt(i));
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            str.append(list.get(i));
        }
        return str.toString();
    }
    public static void main(String[] args) {
        String str = "Hi My name is Heeyeon";

        String reverseStr = reverse(str);
        System.out.println("reverseStr = " + reverseStr);
    }
}
