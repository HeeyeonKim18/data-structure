# Sorting

Sorting is not a big deal when it comes to small datasets. But if there are a lot of large inputs, any company has to care of the costs to process the inputs.
Sorting and searching are really really important.

Sorting: Bubble sort, Insertion sort, Selection sort, Merge sort, Quick sort.

The issue of built-in sort() method is that you never guarantee how it works and we can’t know underneath the hood. For example, in Javascript, an array filled with number is sorted by ASC codes

---

### Bubble Sort

Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order. This algorithm is not suitable for large data sets as its average and worst-case time complexity is quite high.

**How it works?**

Traverse from left and compare adjacent elements and the higher one is placed at right side. In this way, the largest element is moved to the rightmost end at first. This process is then continued to find the second largest and place it and so on until the data is sorted*.*

- Easy, simple, stable and no additional memory space
- But it is less efficient and not suitable for large datasets
- Time complexity: O(n) ~ O(n^2)
- Space complexity: O(1)

- Code
    
    ```java
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
            // sort -> 6, 9, 13, 21, 44, 54
            sort.bubble(new int[]{54, 21, 6, 9, 13, 44});   
        }
    }
    ```
    

---

### Selection Sort

Selection sort is a simple and efficient sorting algorithm that works by repeatedly selecting the smallest element from the unsorted portion of the list and swapping it with the first element of the unsorted part. This process is repeated for the remaining unsorted portion until the entire list is sorted. 

- Simple and easy to understand and works well with small datasets
- But, a time complexity is o(n^2) and does not work well on large datasets
- Time  complexity: O(n^2)
- Space complexity: O(1)

- Code
    
    ```java
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
    ```
    

---

### Insertion Sort

A simple sorting algorithm that works by iteratively inserting each element of unsorted list into its correct position in a sorted portion of the list. It is a stable sorting algorithm, meaning that elements with equal values maintain their relative order in the sorted output.

- Simple and easy to implement, stable sorting algorithm and efficient for small lists and nearly sorted lists
- But, inefficient for large lists and not as efficient as other sorting algorithms list merge, quick sort for most cases
- Time complexity: O(n) ~ O(n^2)
- Space complexity: O(1)

- Code
    
    ```java
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
    ```