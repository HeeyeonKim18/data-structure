package coding.interview.algorithm.sorting;

public class MergeSort {

    private int[] sorted;

    public void merge(int[] arr){
        sorted = new int[arr.length];
        divide(arr, 0, arr.length -1);
        sorted = null;
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private void divide(int[] a, int l, int r) {
        if(l == r) return;
        int mid = (l + r) / 2;
        divide(a, l, mid);
        divide(a, mid + 1, r);
        mergeSort(a, l, mid, r);

    }

    private void mergeSort(int[] a, int l, int m, int r) {
        int left = l;
        int right = m + 1;
        int idx = l;

        while(left <= m && right <= r){
            if(a[left] <= a[right]){
                sorted[idx] = a[left];
                idx++;
                left++;
            }else{
                sorted[idx] = a[right];
                idx++;
                right++;
            }
        }

        if(left > m){
            while(right <= r){
                sorted[idx] = a[right];
                idx++;
                right++;
            }
        }

        else{
            while(left <= m){
                sorted[idx] = a[left];
                idx++;
                left++;
            }
        }

        for (int i = l; i <= r; i++) {
            a[i] = sorted[i];
        }
    }

    public static void main(String[] args){
        int[] arr = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
        MergeSort sort = new MergeSort();
        sort.merge(arr);
    }
}
