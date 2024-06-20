# Hash Tables

- The most common interview questions
- Every language has built-in hash tables just like an array(Java = Map)
- A way hash table works, we have a key and the key is used as a index where to find a value in memory

---

### What is a Hash Function?

It is used all across computer science. it is simply a function that generate a value of fixed length for each input that it gets.

We give it inputs and the function generates some random patterns(MD5, SHA256…) and then a hash number converts to index space or address space based on the number.

### There are some keys aspects of hash function

1. One way: people have no idea what an input is if they see hash numbers.
2. Idempotent: a hash number never changes if an input is same. But if even one letter is changed, it changes completely different output.

---

### Doesn’t hash function make a process slow down?

Hash function is really really fast

### Time complexity: O(1)

- Insert: O(1)
- Lookup: O(1), can be O(n)

- Delete: O(1)
- Search: O(1)

---

### But there is also a problem: Collisions

When it doesn’t have enough memory, hash tables don’t work to store elements in different memory space, which means elements are not evenly distributed and some can be stored in same memory space.

In same memory spaces, values are stored and it slows down reading and writing.

### How to solve collisions?

1. Linked list
2. Open addressing
3. Robin hood hashing

---

- First Recurring Character
    
    ```java
    public class FirstRecurringChar {
        static int result = -1;
        
        static int findOut1(int[] arr){   // O(n^2)
            for(int i = 1; i < arr.length - 1; i++){
                for(int j = i - 1; j >= 0; j--){
                    if(arr[i] == arr[j]){
                        result = arr[i];
                        return result;
                    }
                }
            }
            return result;
        }
    
        static int findOut2(int[] arr){
            HashSet<Integer> set = new HashSet<>();
    
            for(int i = 0; i < arr.length; i++){
                if(set.contains(arr[i])){
                    result = arr[i];
                    return result;
                }
                set.add(arr[i]);
            }
            return result;
        }
    
        static int findOut3(int[] arr){
            HashMap<Integer, Integer> map = new HashMap<>();
    
            for(int i = 0; i < arr.length; i++){
                if(map.containsKey(arr[i])){
                    result = arr[i];
                    return result;
                }
                map.put(arr[i], i);
            }
            return result;
        }
    
        public static void main(String[] args) {
            int[] arr = {2,5,5,2,3,5,1,2,4};
            System.out.println(findOut1(arr));
            System.out.println(findOut2(arr));
            System.out.println(findOut3(arr));
        }
    }
    ```
    
    - Naive way
    1. Using nested loops, the outer loop iterates through the array from the first to the end element and the inner loop iterates the array from i - 1 to 0.
    2. If arr[i] is equal to arr[j], return the element. Otherwise, return -1
    
    - Set
    1. This can be done using HashSet. it loops through the array and the element is stored in the hashset. 
    2. if the hashset contains arr[i], return arr[i]. Otherwise, return -1
    
    - Map
    1. This works same as how set works. 
    2. Map has not only keys but also values, so values are the index of elements.