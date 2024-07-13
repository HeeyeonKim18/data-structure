package coding.interview.algorithm.recursion;

// Given a number N return the index value of the Fibonacci sequence, where the sequence is:

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
// the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3

//For example: fibonacciRecursive(6) should return 8
public class Fibonacci {

    private int[] arr;

    public Fibonacci(int num) {
        this.arr = new int[num + 1];
        arr[0] = 0;
        arr[1] = 1;
    }

    public int fiboRecursive(int num){ // o(2^N)
        if(num < 2) return num;
        return fiboRecursive(num - 2) + fiboRecursive(num - 1);
    }

    public int fiboIterative(int num){ // o(n)
        for (int i = 2; i <= num; i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr[num];
    }

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci(8);
        System.out.println("fibo.fiboRecursive(8) = " + fibo.fiboRecursive(8));
        System.out.println("fibo.fiboIterative(5) = " + fibo.fiboIterative(5));

    }
}
