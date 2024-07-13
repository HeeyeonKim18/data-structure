package coding.interview.data.array;

public class ReverseStrNew {
    public static String reverse(String str) {
        if (checkStr(str)) return str;

        StringBuilder backwards = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            backwards.append(str.charAt(i));
        }
        return backwards.toString();
    }

    public static String reverse2(String str) {
        if (checkStr(str)) return str;

        return new StringBuilder(str).reverse().toString();
    }

    public static String reverse3(String str) {
        if (checkStr(str)) return str;

        return new String(new StringBuilder(str).reverse());
    }

    private static boolean checkStr(String str) {
        if (str == null || str.length() < 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(reverse("Hi My name is Heeyeon"));
        System.out.println(reverse2("Hello this is my coding"));
        System.out.println(reverse3("it is great isn't it?"));
    }
}
