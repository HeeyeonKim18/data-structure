package coding.interview.algorithm.recursion;

public class ReverseString {

    public String iteration(String str){
        String result = "";
        char[] arr = str.toCharArray();
        for(int i = arr.length - 1; i >= 0; i--){
            result += arr[i];
        }
        return result;
    }

    public String recursion(String str){
        if(str.equals("")) return "";
        else return recursion(str.substring(1)) + str.charAt(0);
    }



    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        System.out.println("rs.iteration(\"yoyo master!\") = " + rs.iteration("yoyo master!"));
        System.out.println("rs.recursion(\"yoyo master!\") = " + rs.recursion("yoyo master!"));
    }
}
