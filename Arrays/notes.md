1. Arrays
Access (Read/Write):

Time Complexity: O(1)
Direct access via index is constant time.
Search (Linear Search):

Time Complexity: O(n)
You may need to traverse the entire array to find an element.
Insertion (at a specific index):

Time Complexity: O(n)
Requires shifting elements to make space.
Deletion (at a specific index):

Time Complexity: O(n)
Requires shifting elements to fill the gap.
2. ArrayList (Java)
Access (Read/Write):

Time Complexity: O(1)
Similar to arrays, direct access via index is constant time.
Search (Linear Search):

Time Complexity: O(n)
Traversal is required to locate an element.
Insertion (at the end):

Time Complexity: O(1) (Amortized)
If resizing is not required, adding at the end is constant time.
Resizing: O(n) (when the internal array is full and needs to grow).
Insertion (at a specific index):

Time Complexity: O(n)
Requires shifting elements to make space.
Deletion (at a specific index):

Time Complexity: O(n)
Requires shifting elements to fill the gap.
Key Differences
Resizing:

Arrays have a fixed size, while ArrayLists dynamically resize (doubling their capacity when full). This resizing incurs an O(n) cost occasionally.
Flexibility:

ArrayLists are more flexible as they handle resizing and provide additional utility methods.