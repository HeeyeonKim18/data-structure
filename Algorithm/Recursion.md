# Recursion

### Algorithms

- Data Structures + Algorithms = Programs
- Algorithms allow us to use these data structures to perform actions on that data.
- Algorithms are simply steps in a process that we take to perform a desired action with computers.

An algorithm is a set of commands that must be followed for a computer to perform calculations or other problem-solving operations.

Big O is really important as companies get larger and larger. By learning these listed algorithms(Sorting, Dynamic Programming, BFS + DFS, Recursion), we are able to do majority of the scaling we need to improve our programs.

Certain algorithms allow us to simplify our big complexity into smaller or better time complexity.

---

### Recursion

- Not an algorithm, it is a concept.
- “Anything you do with a recursion can be done iteratively(loop)”

If I want to find a specific file, I can’t do it by just looking at one folder. I want to look at folders recursively to find the file.

The process in which a function calls itself directly or indirectly is called recursion and the corresponding function is called a recursive function. A recursive function solves a particular problem by calling a copy of itself and solving smaller subproblems of the original problems.

It is essential to know that we should provide a certain case in order to terminate this recursion process. So we can say that every time the function calls itself with a simpler version of the original problem.

---

### Steps

1. Define a base case: Identify the simplest case for which the solution is known of trivial. This is the stopping condition for the recursion, as it prevents the function from infinitely calling itself.
2. Define a recursive case: Define the problem in terms of smaller subproblems. Break the problem down into smaller versions of itself, and call the function recursively to solve each subproblem.
3. Ensure the recursion terminates: Make sure that the recursive function eventually reaches the base case, and does not enter the infinite loop.
4. Combine the solutions: Combine the solutions of the subproblems to solve the original problem.

---

### Problems

1. Difficult to understand
2. Calling functions over and over causes stack overflow
3. Time complexity: O(2^N)

**Why stack overflow error occurs in recursion?**

If the base case is not reached or not defined, then the stack overflow problem may arise.

**How to make it efficient?**

Time complexity can be O(N) using dynamic programming and memoization.

---

### When to use Recursion

- Every time you are using a tree or converting something into a tree, consider recursion.
    1. Divided into a number of subproblems that are smaller instances of the same problem.
    2. Each instance of the subproblems is identical in nature.
    3. The solutions of each subproblem can be combined to solve the problem at hand.

- Divide and conquer using recursion