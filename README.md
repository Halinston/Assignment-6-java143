reverse() Method for List class Start with classes List class provided.

Add a new public method void reverse() to the class. The method must reverse the linked list data structure. You can implement either iterative or recursive solution. Make sure you solution works for empty list as well as with a list with just one element.

Requirement:

Complexity of your solution must be O(N). More than that, the problem must be solved with one pass through the list. Do not create new list nodes, rewire the existing list. General rule: do not create new Nodes. "new" keyword is prohibited in your solution. reverseToString() and recReverseToString() Add two more methods to the List class:

public String reverseToString() method creates a string that holds all the integers in the list in reverse order in the format “6 5 4 3 2 1” (all list values are separated only by white spaces) Requirements:

DO NOT reverse list, just traverse it and create a string that holds the elements in reverse order. Your solution must be O(N). This solution must be iterative. public String recReverseToString() is a RECURSIVE method with the same functionality - creates a string that holds all the integers in the list in reverse order. Write a recursive method recReverseToString(Node cur) and then write a wrapper method that calls it. The signature of the wrapper method would be recReverseToString() – it does not take parameters. Requirements:

DO NOT reverse list, just traverse it and create a string that holds the elements in reverse order. Your solution must be O(N). This solution must be recursive. You are not allowed to use StringBuilder, ArrayList or any other structures for intermediate storage. Do not introduce new fields to the class! You are not allowed to reverse the string after it has been created. Clone() Method Add a clone() method to create a deep copy of the list. Traverse the original list; for each node create a copy and add that copy to the cloned list. You are encouraged to use "new" keyword in this solution.

Requirement:

Your solution must be linear – O(N). This means you want to avoid using add(int) just because every time it traverses the whole list to add a new element. This would make your solution O(N2) Make sure to handle CloneNotSupportedException

smallestFirst() Method Add void smallestFirst() method that moves the node with the smallest integer in the list to become the first node.

Requirements:

Your solution must be linear - O(N). More than that, you must solve the problem with only one pass through the list. Avoid using remove(int index) and add(int index, int e). “Rewire” the list by hand instead. Do not copy values from node to node. Instead rewire the node so that it appears first in the list. When values in nodes are big objects copying them back and forth may become very time - consuming. General rule: do not create new Nodes. "new" keyword is prohibited in your solution.

selectionSort() Method Add void selectionSort() method that sorts the list.

Requirements:

Your solution must be no more than O(N2) Do not call on any existing methods from the class in this implementation. You can use code you wrote when implementing smallestFirst, Do not copy values from node to node. Instead rewire the nodes so that they are appearing in the correct spot in the list. General rule: do not create new Nodes. "new" keyword is prohibited in your solution.