
/**
 * Represents a linked list with various operations.
 */
public class List extends HasState implements Cloneable {
  /**
     * Inner class representing a node in the linked list.
     */
    private class Node {
        int value;
        Node next;
        /**
           Constructor.            
           @param val The element to store in the node.
           @param n The reference to the successor node.
        */
        Node(int val, Node n) {
            value = val;
            next = n;
        }
        /**
           Constructor. 
           @param val The element to store in the node.
        */
        Node(int val) {
            this(val, null);
        }
    }

    private Node first;
    /**
       Constructor.
    */
    public List() {
        first = null;
    }
    /**
       The isEmpty method checks to see 
        if the list is empty.
        @return true if list is empty, false otherwise.
    */
    
    public boolean isEmpty() {
        return first == null;
    }
    /**
       The size method returns the length of the list.
       @return The number of elements in the list.
    */
    public int size() {
        int count = 0;
        Node p = first;
        while (p != null) {
                       // There is an element at p
            count++;
            p = p.next;
        }
        return count;
    }
    /**
       The add method adds an element to
		 the end of the list.
       @param e The value to add to the
		 end of the list.       
    */
    public void add(int e)
    {
      if (isEmpty()) 
      {
          first = new Node(e);
      }
      else
      {
          // Add to end of existing list
          Node current = first;
          // moving current reference to the ent of the list
          while(current.next!=null) current = current.next;
          
          current.next = new Node(e);
          
      }      
    }
    /**
       The add method adds an element at a position.
       @param e The element to add to the list.
       @param index The position at which to add 
		 the element.
       @exception IndexOutOfBoundsException When 
		 index is out of bounds.  
    */
    public void add(int index, int val) {
        if (index < 0) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        if (index == 0) {
            first = new Node(val, first);
            return;
        }

        Node cur = first;
        int count = 0;
        while (cur != null && count != index - 1) {
            cur = cur.next;
            count++;
        }
        if (cur == null) throw new IndexOutOfBoundsException(String.valueOf(index));
        Node tmp = new Node(val, cur.next);
        cur.next = tmp;
    }

    /**
     * Reverses the order of elements in the list.
     */
    public void reverse() {
        // Initialize three pointers: prev, current, and next.
        // prev is initially null because there's no node before the first node.
        Node prev = null;
        // current starts from the first node.
        Node current = first;
        // next is initially null and will be used to temporarily hold the next node.
        Node next = null;

        // Traverse the list until current is null, which means we've reached the end of the list.
        while (current != null) {
            // Before changing current.next, store the next node in next.
            next = current.next;
            // Reverse the link by making current.next point to prev.
            current.next = prev;
            // Move prev and current one step forward. prev becomes the current node, and current becomes the next node.
            prev = current;
            current = next;
        }

        // After all nodes have been visited, prev is at the last node, which becomes the new first node.
        first = prev;
    }

    /**
     * Returns a string representation of the list in reverse order.
     *
     * @return A string with elements in reverse order.
     */
    public String reverseToString() {
        // Initialize a StringBuilder to build the result string.
        StringBuilder result = new StringBuilder();
        // Start from the first node.
        Node current = first;

        // Traverse the list until current is null, which means we've reached the end of the list.
        while (current != null) {
            // Insert the current node's value at the beginning of the result string.
            // This effectively reverses the order of elements.
            // Add a space after each value for separation.
            result.insert(0, current.value + " ");
            // Move to the next node.
            current = current.next;
        }

        // Convert the result StringBuilder to a string and trim any leading or trailing spaces.
        // The trim() method is necessary because we added a space after each value, including the last one.
        return result.toString().trim();
    }
    /**
     * Recursive helper method to create a string representation of the list in reverse order.
     *
     * @param cur The current node.
     * @return A string with elements in reverse order.
     */
    private String recReverseToString(Node cur) {
        // Base case: if cur is null, we've reached the end of the list, so return an empty string.
        if (cur == null) {
            return "";
        }
        // Recursive case: first recursively call recReverseToString for the next node, then append the current node's value.
        // This effectively reverses the order of elements because the current node's value is appended after the rest of the list.
        // Add a space after each value for separation.
        return recReverseToString(cur.next) + cur.value + " ";
    }

    /**
     * Wrapper method to create a string representation of the list in reverse order.
     *
     * @return A string with elements in reverse order.
     */
    public String recReverseToString() {
        // Call the recursive helper method with the first node as the starting point.
        // Trim any leading or trailing spaces from the result.
        // The trim() method is necessary because we added a space after each value, including the last one.
        return recReverseToString(first).trim();
    }
    
    /**
     * Creates a deep copy of the list.
     *
     * @return A deep copy of the list.
     */

    @Override
    public List clone() {
        try {
            List clonedList = (List) super.clone();
            clonedList.first = cloneList(this.first);
            return clonedList;
        } catch (CloneNotSupportedException e) {
            // Handle the exception, if necessary
            e.printStackTrace();
            return null;
        }
    }

    private Node cloneList(Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.value);
        newNode.next = cloneList(node.next);
        return newNode;
    }
    /**
     * Moves the node with the smallest integer in the list to become the first node.
     */
    public void smallestFirst() {
        if (first == null) {
            return;
        }

        Node minPrev = null;
        Node minNode = first;
        Node current = first.next;

        while (current != null) {
            if (current.value < minNode.value) {
                minPrev = minNode;
                minNode = current;
            }
            current = current.next;
        }

        if (minPrev != null) {
            minPrev.next = minNode.next;
            minNode.next = first;
            first = minNode;
        }
    }
    /**
     * Sorts the list using the selection sort algorithm.
     */
    public void selectionSort() {
        Node current = first;
        Node head = first;
    
        while (current != null) {
            Node minNode = current;
            Node checkNode = current.next;
    
            while (checkNode != null) {
                if (checkNode.value < minNode.value) {
                    minNode = checkNode;
                }
                checkNode = checkNode.next;
            }
    
            // Find previous nodes
            Node prevCurrent = null, prevMin = null;
            Node tempNode = head;
            while (tempNode != null) {
                if (tempNode.next == current) prevCurrent = tempNode;
                if (tempNode.next == minNode) prevMin = tempNode;
                tempNode = tempNode.next;
            }
    
            // Swap nodes
            if (prevCurrent != null) prevCurrent.next = minNode;
            if (prevMin != null) prevMin.next = current;
    
            Node temp = current.next;
            current.next = minNode.next;
            minNode.next = temp;
    
            if (current == head) head = minNode;
            else if (minNode == head) head = current;
    
            current = (current == head) ? head.next : head;
        }
    
        first = head;
    }
    /**
       The toString method computes the string
       representation of the list.
       @return The string form of the list.
    */
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        Node p = first;
        while (p.next != null) {
            strBuilder.append(p.value).append("->");
            p = p.next;
        }
        strBuilder.append(p.value);
        return strBuilder.toString();
    }
    /**
       The remove method removes the element at an index.
       @param index The index of the element to remove. 
       @return The element removed.  
       @exception IndexOutOfBoundsException When index is 
                  out of bounds.     
    */
    public int remove(int index) {
        if (first == null) throw new IndexOutOfBoundsException(String.valueOf(index));
        if (index < 0) throw new IndexOutOfBoundsException(String.valueOf(index));

        int val;
        if (index == 0) {
            val = first.value;
            first = first.next;
            return val;
        }
        Node cur = first;
        int count = 0;
        while (cur != null && count != index - 1) {
            cur = cur.next;
            count++;
        }
        if (cur == null) throw new IndexOutOfBoundsException(String.valueOf(index));
        if (cur.next == null) throw new IndexOutOfBoundsException(String.valueOf(index));
        val = cur.next.value;
        cur.next = cur.next.next;
        return val;
    }
    /**
      Method compares two lists, returns true if they are equal
      @param obj the object to compare to. 
      @return if the objects are equal the method returns true, otherwise returns false.
    */

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        List a = (List) obj;
        Node curThis = this.first;
        Node curObj = a.first;
        while (curThis != null && curObj != null) {
            if (curThis.value != curObj.value) return false;
            curThis = curThis.next;
            curObj = curObj.next;
        }
        return curThis == curObj;
    }
}
