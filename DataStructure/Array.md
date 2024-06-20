# Array

Array, sometimes called list, organizes items sequentially that means one after and it has indexes and contents after.

- Simplest and most common use as a data structure
- Stored in contiguous memory in order
- Iterating over all datas that are stored

---

### Time complexity

Lookup: O(1)

Push: O(1)

Insert(add an item at the end of an array): O(1)

Delete: O(1)

Pop(remove an item at the end of an array): O(1)

### Space complexity

if 32 bits system and four items are stored in an array,

one items needs 4 shelves(4 * 4 = 16 bytes) to be stored

Two types of Arrays: Static(an array in Java) VS Dynamic(an ArrayList)

Static: fixed in size ahead

Dynamic: allow us to copy and rebuild an array at a new location

**If using static memory is not enough, how do you deal with?**

1. Copy the array that has not enough memory
2. Create new an array in a bigger size
3. Paste all items in previous array

---

### Time Complexity in Java between Array and ArrayList

**Array**

Lookup O(1)

Searching O(n)

Insert and delete O(1) || O(n)<- depending on where an element adds

**ArrayList**

Add O(1)

Add(index, element) O(n)

Get O(1)

Remove O(n)

IndexOf O(n)

Contain O(n)

---

### Solution of Reverse a String

**First Solution**

1. Check if it is not null and the length of String is greater than two
2. Create a StringBuilder object named 'backwards'
3. Create for loops through over each charset of Stirng from the length of String -1 to 0
4. Appends the index of the char
5. Return backwards as a String

**Second Solution**

1. Check if it is not null and the length of String is greater than two
2. use built-in methods in StringBuilder class. There is a reverse method which can make String reverse
3. Return new StringBuilder(str).reverse().toString();

### Solution Merge Sorted Arrays

1. To avoid any extra work, check inputs if an array is empty, which I don't need to marge and sort two arrays
2. Create elements int i, int j
3. Use a while loop and compare arr1[i] with arr2[j]. If the arr1[i] is smaller than arr2[j], pash the arr1[i] then increase the index, int i. Otherwise the index, int j, is increased.

---

### Pros and Cons of Arrays

**Pros**

- Fast lookups
- Fast push and pop(the end of array)
- Ordered

**Cons**

- Slow inserts
- Slow deletes
- Fixed Size(if using static arrays)

---

### Coding Test

- [x]  https://leetcode.com/problems/two-sum/description/
    - Code and description
        - Brute Force
        
        ```java
        class Solution {
            public int[] twoSum(int[] nums, int target) {
                int n = nums.length;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (nums[i] + nums[j] == target) {
                            return new int[]{i, j};
                        }
                    }
                }
                return new int[]{}; // No solution found
            }
        }
        ```
        
        1. One brute force approach is to consider every pair of elements and check if their sum equals the target. This can be done using nested loops, where the outer loop iterates from the first element to the second-to-last element, and the inner loop iterates from the next element to the last element. However, this approach has a time complexity of O(n^2).
        
        - Using HashMap
        
        ```java
        class Solution {
            public int[] twoSum(int[] nums, int target) {
                HashMap<Integer, Integer> map = new HashMap<>();
        
                // return the array
                int[] result = new int[2];
        
                for(int i = 0; i < nums.length; i++){
        
                    // if map has nums[i] as a key?
                    if(map.containsKey(nums[i])){
                        // return the number of index that I saved as a value,
                        // and the num[i]
                        result[0] = map.get(nums[i]);
                        result[1] = i;
                        break;
                    }
        
                    // save the complement as a key and i, an index as a value
                    map.put(target - nums[i], i);
                }
                return result;
            }
        }
        ```
        
        1. Inside the method, we create a new empty HashMap. This HashMap stores each element of nums as its key and the corresponding index as its value.
        2. We iterate through each element in nums with a for loop. For each element, we calculate its complement with respect to target.
        3. We check if complement is already stored in map. If it is (`'map.containsKey(nums[i])'` returns true), we've found two elements whose sum is the target. We then return an array containing their indices by calling `map.get(nums[i])` and `i`.
        4. If the nums[i] isn't in map, we add the complement and its index to map.
- [x]  https://leetcode.com/problems/maximum-subarray/description/
    - Code and description
        - Brute Force
        
        ```java
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
        		int sum = 0;
        		for(int j = i; j < nums.length; j++){
        				sum += nums[j];
        				max = Math.max(max, sum);
        		}
        }
        return max;
        ```
        
        1. `max` represents the maximum sum encountered so far and is initially set to the minimum possible integer value to ensure that any valid subarray sum will be greater than it.
        2. Iterate through the `nums` array using a for loop, starting from the first element and going up to the last element. A nested for loop starts from the i to the last element
        3. `max`, this calculates the sum of the subarray ending at the current element.
        4. Return the greatest number of the subarray
        
        - Dynamic Programming
        
        ```java
        int length = nums.length;
        int[] arr = new int[length];
        
        arr[0] = nums[0];
        
        for(int i = 1; i < length; i++){
        		arr[i] = Math.max(arr[i-1] + nums[i], nums[i]);
        }
        
        int max = arr[0];
        for(int i = 1; i < length; i++){
        		max = Math.max(max, arr[i]);
        }
        
        return max;
        ```
        
        1. `arr` represents the maximum of each index to compare the previous index of a number and the index of i in the array of nums.
        2. Create the other for loop to find out the maximum number in the arr array
        3. return max value
        
        - Without Creating a new array
        
        ```java
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        		currentSum = Math.max(nums[i], currentSum + nums[i]);
        		maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
        ```
        
        1. `maxSum` represents the maximum sum encountered so far and is initially set to the minimum possible integer value to ensure that any valid subarray sum will be greater than it.
        2. `currentSum` represents the current sum of the subarray being considered and is initially set to 0.
        3. Iterate through the `nums` array using a for loop, starting from the first element and going up to the last element.
        4. For each element in the array, we add it to the current sum `currentSum`. This calculates the sum of the subarray ending at the current element.
        5. Next, we check if the current sum `currentSum` is greater than the current maximum sum `maxSum`.
            - If it is, we update `maxSum` with the new value of `currentSum`. This means we have found a new maximum subarray sum.
        6. If the current sum `currentSum` becomes negative, it indicates that including the current element in the subarray would reduce the overall sum. In such cases, we reset `currentSum` to 0. This effectively discards the current subarray and allows us to start a fresh subarray from the next element.
        7. We repeat steps 3 to 5 for each element in the array.
        8. After iterating through the entire array, the variable `maxSum` will contain the maximum subarray sum encountered.
        9. Finally, we return the value of `maxSum` as the result, representing the maximum sum of a contiguous subarray within the given array `nums`.
        
- [x]  https://leetcode.com/problems/move-zeroes/description/
    - Code and description
        
        ```java
        class Solution {
            public void moveZeroes(int[] nums) {
                if (nums.length == 1) {
                    return;
                }
                
                int countZero = 0;
                int j = 0;
                
                for(int i = 0; i < nums.length; i++){
                    if(nums[i] == 0){
                        countZero++;
                    }else{
                        nums[j++] = nums[i];
                    }
                }
        
                for(int i = 0; i < countZero; i++){
                    nums[j++] = 0;
                }
            }
        }
        ```
        
        1. I will start by checking if the input array nums contains only one element; if it does, there's nothing to move, so I'll return early. Otherwise, I'll initialize a variable countZero how many zero is stored in the array nums and a variable j to store numbers and increment it if it is not zero.
        2. I will then iterate through the array using a for loop. For each element, if it's zero, I will increment countZero. Otherwise I will shifts all non-zero element to the front of the array while preserving their original order.
        3. Finally, I'll fill the remaining positions in the array (from 0 to the countZero) with zeros using a for loop.
- [x]  https://leetcode.com/problems/contains-duplicate/description/
    - Code and description
        - Brute Force
        
        ```java
        class Solution {
            public boolean containsDuplicate(int[] nums) {
                int n = nums.length;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (nums[i] == nums[j])
                            return true;
                    }
                }
                return false;
            }
        }
        ```
        
        1. The brute force approach compares each element with every other element in the array to check for duplicates. If any duplicates are found, it returns `true`. This approach is straightforward but has a time complexity of O(n^2), making it less efficient for large arrays.
        
        - Sorting
        
        ```java
        class Solution {
            public boolean containsDuplicate(int[] nums) {
                Arrays.sort(nums);
                int n = nums.length;
                for (int i = 1; i < n; i++) {
                    if (nums[i] == nums[i - 1])
                        return true;
                }
                return false;
            }
        }
        ```
        
        1. First Sort the Array.
        2. Then Compare elements one by one.
        3. We Only have to return a boolean value.
        4. Sorting has a time complexity of O(n log n)
        
        - HashSet
        
        ```java
        class Solution {
            public boolean containsDuplicate(int[] nums) {
                HashSet<Integer> findDuplicate = new HashSet<>();
        
                for(int i = 0; i < nums.length; i++){
                    if(findDuplicate.contains(nums[i])){
                        return true;
                    }
                    findDuplicate.add(nums[i]);
                }
                return false;
            }
        }
        ```
        
        1. Create HashSet
        2. Iterate through the nums array and return true if the set contains nums[i] using a for loop. Otherwise nums[i] is added in the set
        3. If there are not duplicated numbers, return false
        4. The time complexity of this approach is `O(n)`, where n is the length of the array.
- [x]  https://leetcode.com/problems/rotate-array/description/
    - Code and description
        
        ```java
        class Solution {
            public void rotate(int[] nums, int k) {
                int length = nums.length;
                k %= length;
        
                reverse(nums, 0, length - 1);
                reverse(nums, 0, k - 1);
                reverse(nums, k, length - 1);
                
            }
            public void reverse(int nums[], int start, int end){
                while(start < end){
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
        
                    start++;
                    end--;
                }
            }
        }
        ```
        
        1. First, it calculates the effective rotation amount by taking the modulus of k with the length of the array, ensuring that k is within the range of the array length.
        2. Then, it calls the reverse function three times:
            - First, it reverses the entire array, effectively placing the last k elements at the start of the array.
            - Second, it reverses the first k elements, moving them to the end of the array.
            - Finally, it reverses the remaining elements, restoring the original order of the array with the elements rotated to the right by k steps.
        - Time complexity: O(n)
        - Space complexity: O(1)
- [ ]  [https://www.coderbyte.com/language/Longest Word](https://www.coderbyte.com/language/Longest%20Word)