package coding.interview.algorithm.sorting;

public class SelectionSort {

    public void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int tmp = arr[i];
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            arr[i] = arr[min];
            arr[min] = tmp;
        }

        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        SelectionSort selection = new SelectionSort();
        selection.sort(new int[]{5, 7, 0, 2, 1, 4});
    }
}
