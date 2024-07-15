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