package coding.interview.algorithm.sorting;

public class InsertionSort {

    public void sort(int[] arr){ // {23, 1, 10, 5, 2}
        for (int i = 1; i < arr.length ; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        InsertionSort insertion = new InsertionSort();
        insertion.sort(new int[]{23, 1, 10, 5, 2});
    }
}
