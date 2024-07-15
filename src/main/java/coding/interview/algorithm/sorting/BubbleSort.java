package coding.interview.algorithm.sorting;

public class BubbleSort {

    public void bubble(int[] arr) {
        int cnt = arr.length - 1;
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j+1);
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        BubbleSort sort = new BubbleSort();
        sort.bubble(new int[]{54, 21, 6, 9, 13, 44});   // sort -> 6, 9, 13, 21, 44, 54
    }
}
