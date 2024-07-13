package coding.interview.algorithm.recursion;

// Write two functions that finds the factorial of any number.
// One should use recursive, the other should just use a for loop
public class Factorial {

    public static int factorialRecursion(int num){
        if(num == 1) return 1;
        return num * factorialRecursion(num - 1);
    }

    public static int factorialIteration(int num){
        int result = 1;
        for (int i = 2; i <= num; i++) {
           result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorialRecursion(5));
        System.out.println(factorialIteration(5));
    }
}
