minHeap- value of node is less than or equal to its child nodes
maxHeap- value of node is greater than or equal to its child nodes

operations-log2N
search- O(n)
implement thorugh Array
To find minimum and maximum element in constant time

if parent is at ith index->
left child would be at 2*i+1
right child would be at 2*i+2

if child is at jth index->
parent will be at ceil val of j/2-1

if height of array is 'h' 
max nodes->2^(h+1)-1   // h start from 0

if total N nodes
height-> floor val of log2N

Range of leave Node in CBT is
floor n/2 to n-1  (for '0' based indexing)

Heapify-> The process of the heap by recursively somparing a parent nodes with its child node!

There can be two different Heap tree can be generated because there is no realtion between there sibling node of the tree.

Complexity-->
Heapify - O(log2N)[height]
buildHeap - O(n)
extraxt max - O(1)+O(loog2N)[heapify]
increase  key - o(log2N)(bottomup-height)
decrease key - O(log2N)(topdown - height)
insert element - O(1)+log2N(bottom up)
heap sort - (Nlog2N)
