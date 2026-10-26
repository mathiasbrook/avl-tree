# AVL Tree

A generic self-balancing binary search tree (AVL tree) in Java that stores key-value pairs.

## Features
- Generic keys and values: `AVLTree<K extends Comparable<K>, E>`
- Insert with automatic rebalancing for all four cases (left-left, right-right, left-right, right-left)
- Each node keeps its height so balance factors are quick to check
- Duplicate keys are ignored
- In-order and pre-order traversals, tree height and an `isBalanced()` check

## How to run
Demo:
```
javac AVLTree.java && java AVLTree
```
Tests:
```
javac AVLTree.java AVLTest.java && java AVLTest
```

## Sample output
`java AVLTree`:
```
Inserted: 6 1 4 7 9 3 8 0 2 5 6 4
In order:  0 1 2 3 4 5 6 7 8 9 
Pre order: 4 1 0 3 2 7 6 5 9 8 
Values:    CBRNAELNAA
Height: 4   Balanced? true

Inserted 1 to 1000 in order
Height: 10 (a plain BST would be 1000)   Balanced? true
```

`java AVLTest`:
```
Expected 0 1 2 3 4 5 6 7 8 9  0 1 2 3 4 5 6 7 8 9 
Expected CBRNAELNAA  CBRNAELNAA
Expected true  true
Expected 4  4
Expected 2 1 3  2 1 3 
Expected 2 1 3  2 1 3 
Expected 2 1 3  2 1 3 
Expected 2 1 3  2 1 3
```

## Concepts used
- Binary search trees
- Recursion (insert and the traversals)
- Tree rotations and balance factors
- Generics with `Comparable`
- Private inner classes

## What I'd add next
- Delete with rebalancing
- A `get(key)` search method and updating the value for a duplicate key
- A simpler `insert(key, value)` so you don't have to pass the root in
- Printing the tree sideways so you can see the shape
