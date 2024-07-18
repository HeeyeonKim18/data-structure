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
    

---

### Merge Sort

A sorting algorithm that follows the divide-and-conquer approach. It works by recursively dividing the input array into smaller subarrays and sorting those subarrays them merging them back together to obtain the sorted array. It is a popular sorting algorithm known for its efficiency and stability.

`In simple terms, we can say that the process of merge sort is to divide the array into two halves, sort each half, and then merge the sorted halves back together. This process is repeated until the entire array is sorted.` 

**Steps**

- Divide: Divide the list or array recursively into two halves until it can no more be divided.
- Conquer: Each subarray is sorted individually using the merge sort algorithm.
- Merge: The sorted subarrays are merged back together in sorted order. The process continues until all elements from both subarrays have been merged.

- Sorting large datasets, it is stable, efficient and it is simple to implement.
- but it requires additional memory.
- Time complexity: O(n log n)
- Space complexity: O(n)

- code
    
    ```java
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
    ```
    

---

### Quick Sort

*A sorting algorithm based on the **Divide and Conquer algorithm** that picks an element as a pivot and partitions the given array around the picked pivot by placing the pivot in its correct position in the sorted array.*

**To choose pivots**

- First element
- Last element
- Random element
- Middle element

- It is efficient on large data sets and usual time complexity is O(n log n)
- Worst-case time complexity of O(n^2) and it is unstable
- Time complexity: O(n log n) ~ O(n^2)
- Space complexity: O(log n) ~ O(n)

---

### **What is stability in sorting algorithms ?**

A sorting algorithm is said to be stable if two objects with equal keys appear in the same order in sorted output as they appear in the input array to be sorted. Some sorting algorithms are stable by nature like Insertion sort, Merge Sort, Bubble Sort, etc. And some sorting algorithms are not, like Heap Sort, Quick Sort, etc.

*Background*: a "stable" sorting algorithm keeps the items with the same sorting key in order. Suppose we have a list of 5-letter words:

```
peach
straw
apple
spork
```

If we sort the list by just the first letter of each word then a stable-sort would produce:

```
apple
peach
straw
spork
```

In an **unstable** sort algorithm, `straw` or `spork` may be interchanged, but in a stable one, they stay in the same relative positions (that is, since `straw` appears before `spork` in the input, it also appears before `spork` in the output).

We could sort the list of words using this algorithm: stable sorting by column 5, then 4, then 3, then 2, then 1. In the end, it will be correctly sorted. Convince yourself of that. (by the way, that algorithm is called radix sort).

---

### Which Sort is Best?

**Insertion Sort**

- Best used for small datasets.
- Efficient when the data is almost sorted.
- Time complexity: O(n²) in the worst case, but O(n) in the best case when the data is nearly sorted.

**Bubble Sort**

- Generally used for educational purposes due to its inefficiency.
- Rarely used in practice.
- Time complexity: O(n²).

**Selection Sort**

- Similar to Bubble Sort in terms of inefficiency.
- Primarily used for educational purposes.
- Time complexity: O(n²).

**Merge Sort**

- Highly efficient with a consistent time complexity of O(n log n).
- Requires additional space for merging, which can be a drawback.
- Guarantees O(n log n) time complexity even in the worst case.

**Quick Sort**

- Popular and efficient with average time complexity of O(n log n).
- Space complexity is O(log n), making it more space-efficient than Merge Sort.
- However, has a worst-case time complexity of O(n²), which occurs with poorly chosen pivots.

**Heap Sort**

- Similar in efficiency to Merge Sort and Quick Sort.
- Space complexity: O(1), which is better than Merge Sort.
- Slower than Quick Sort in practice despite having the same O(n log n) time complexity.

### Why is Quick Sort Faster than Heap Sort Despite Having the Same Time Complexity?

The key advantage of Quick Sort is its fewer number of swaps:

- Quick Sort minimizes unnecessary swaps, which are time-consuming operations.
- Heap Sort involves many swaps, even if the data is already ordered.
- Merge Sort involves writing data to additional arrays, which also increases time consumption.

---

### Radix Sort and Counting Sort

**Comparison Sorts**

- Examples: Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort.
- Mathematically, comparison-based sorts cannot be better than O(n log n) in the worst case because each element must be compared.

**Non-Comparison Sorts**

- Examples: Radix Sort, Counting Sort.
- These sorts work with specific types of data, such as integers of fixed length.
- They avoid comparisons between elements, resulting in time complexities of O(nk) or O(n + k), where k is a constant. This can be more efficient than O(n log n) for large datasets with small range values.

---

### Case

**#1 - Sort 10 schools around your house by distance:**
insertion sort

**#2 - eBay sorts listings by the current Bid amount:**
radix or counting sort

**#3 - Sort scores on ESPN**
Quick sort

**#4 - Massive database (can't fit all into memory) needs to sort through past year's user data**
Merge Sort

**#5 - Almost sorted Udemy review data needs to update and add 2 new reviews**
Insertion Sort

**#6 - Temperature Records for the past 50 years in Canada**
radix or counting Sort
Quick sort if decimal places

**#7 - Large user name database needs to be sorted. Data is very random.**
Quick sort

**#8 - You want to teach sorting**
Bubble sort