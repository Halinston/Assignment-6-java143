import java.io.PrintWriter;

public class TestList {

    /**
    * Runs all tests for reverse() method
    * @param outputStream - output stream, used to print into the screen
    */
   public static boolean testReverse(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 2;
       
	   outputStream.println("\r\n----reverse() TEST SETS -------------------------------------------------------\r\n");

	   List list1 = new List();
       list1.add(1);
       list1.add(2);
       list1.add(3);
       list1.add(4);
       list1.add(5);
       list1.add(6);
       
       List list2 = new List();
       list2.add(100);
       list2.add(101);     
       
       List list3 = new List();
       list3.add(100);
        
       List list4 = new List();
       list1.reverse();
       list2.reverse();
       list3.reverse();
       
// Test #1   
      if( list1.toString().equals("6->5->4->3->2->1") && list2.toString().equals("101->100") && list3.toString().equals("100")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 01 reverse() - regular functionality",  "PASSED");
           count++;
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 01 reverse() - regular functionality",  "FAILED");

//Test #2 
       list4.reverse();
      if(list4.isEmpty()) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 01 reverse() - empty list",  "PASSED");
           count++;
          
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 01 reverse() - empty list",  "FAILED");
      
      return count==expectedCount;
   }

   /**
    * Runs all tests for reverseToString() and recReverseToString() method
    * @param outputStream - output stream, used to print into the screen
    */
   public static boolean testReverseToString(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 4;

	   outputStream.println("\r\n----Iterative reverseToString() TEST SETS ---------------------------------------\r\n");

	   List list1 = new List();
       list1.add(1);
       list1.add(2);
       list1.add(3);
       list1.add(4);
       list1.add(5);
       list1.add(6);
       
       List list2 = new List();
       list2.add(100);
       list2.add(101);     
       
       List list3 = new List();
       list3.add(100);
        
       List list4 = new List();
       String s1 = list1.reverseToString();
       String s2 = list2.reverseToString();
       String s3 = list3.reverseToString();

// Test #1   
      if( s1.equals("6 5 4 3 2 1") && s2.equals("101 100") && s3.equals("100")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 02 reverseToString() - regular functionality",  "PASSED");
           count++;
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 02 reverseToString() - regular functionality",  "FAILED");

//Test #2 
       String s4 = list4.reverseToString();
      if(s4.equals("")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 02 reverseToString() - empty list",  "PASSED");
           count++;
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 02 reverseToString() - empty list",  "FAILED");


	   outputStream.println("\r\n---- Recursive recReverseToString() TEST SETS -----------------------------------------\r\n");
       
       s1 = list1.recReverseToString();
       s2 = list2.recReverseToString();
       s3 = list3.recReverseToString();
       
// Test #3   
      if( s1.equals("6 5 4 3 2 1") && s2.equals("101 100") && s3.equals("100")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 02 recReverseToString() - regular functionality",  "PASSED");
           count++;
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 02 recReverseToString() - regular functionality",  "FAILED");

//Test #4 
      s4 = list4.recReverseToString();
      if(s4.equals("")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 02 recReverseToString() - empty list",  "PASSED");
           count++;
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 02 recReverseToString() - empty list",  "FAILED");

      return count==expectedCount;
   }

    /**
    * Runs all tests for clone() method
    * @param outputStream - output stream, used to print into the screen
    */
   public static boolean testClone(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 3;

	   outputStream.println("\r\n---- clone() TEST SETS -------------------------------------------------------\r\n");

       List list1 = new List();
       list1.add(1);
       list1.add(2);
       list1.add(3);
       list1.add(4);
       list1.add(5);
       list1.add(6);
       
       List list2 = new List();
       list2.add(100);
       list2.add(101);     
       
       List list3 = new List();
       list3.add(100);
        
       List list4 = new List();

       List copyList1 = list1.clone();
       List copyList2 = list2.clone();
       List copyList3 = list3.clone();
       
// Test #1   
    // Test #1   
       if( list1.equals(copyList1) && list1.getObjState() == copyList1.getObjState()
     		  && list2.equals(copyList2) && list2.getObjState() == copyList2.getObjState()
     		  && list3.equals(copyList3) && list3.getObjState() == copyList3.getObjState()) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 03 clone() - regular functionality",  "PASSED");
           count++;
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 03 clone() - regular functionality",  "FAILED");

//Test #2 
      List copyList4 = list4.clone();
      if(copyList4.isEmpty()) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 03 clone() - empty list",  "PASSED");
           count++;
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 03 clone() - empty list",  "FAILED");

//Test #3 - deep copy
       list1.add(3, 1000);
       if( !list1.equals(copyList1) && !copyList1.toString().equals("1->2->1000->3->4->5->6")  ) 
        {
            outputStream.printf("%-80s%-10s\r\n", "TEST SET 03 clone() - deep copy test",  "PASSED");
            count++;
        }
        else outputStream.printf("%-80s%-10s\r\n", "TEST SET 03 clone() - deep copy test",  "FAILED");

       return count==expectedCount;
   }    
   
    /**
    * Runs all tests for smallestFirst() method
    * @param outputStream - output stream, used to print into the screen
    */
   public static boolean testSmallestFirst(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 2;

	   outputStream.println("\r\n---- smallestFirst() TEST SETS -------------------------------------------------------\r\n");

       List list1 = new List();
       list1.add(6);
       list1.add(5);
       list1.add(4);
       list1.add(1);
       list1.add(3);
       list1.add(2);
       
       List list2 = new List();
       list2.add(102);
       list2.add(101);     
       
       List list3 = new List();
       list3.add(100);
        
       List list4 = new List();
       
       list1.smallestFirst();
       list2.smallestFirst();
       list3.smallestFirst();

// Test #1   
      if( list1.toString().equals("1->6->5->4->3->2") && list2.toString().equals("101->102") && list3.toString().equals("100")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 04 smallestFirst() - regular functionality",  "PASSED");
           count++;
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 04 smallestFirst() - regular functionality",  "FAILED");

//Test #2 
       list4.smallestFirst();
      if(list4.isEmpty()) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 04 smallestFirst() - empty list",  "PASSED");
           count++;
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 04 smallestFirst() - empty list",  "FAILED");

      return count==expectedCount;
   }
   
   /**
    * Runs all tests for selectionSort() method
    * @param outputStream - output stream, used to print into the screen
    */
   public static boolean testSelectionSort(PrintWriter outputStream)
   {
       int count = 0;
       int expectedCount = 2;
       
	   outputStream.println("\r\n---- selectionSort() TEST SETS -------------------------------------------------------\r\n");
	   
       List list1 = new List();
       list1.add(6);
       list1.add(5);
       list1.add(3);
       list1.add(4);
       list1.add(2);
       list1.add(1);
       
       List list2 = new List();
       list2.add(102);
       list2.add(101);     
       
       List list3 = new List();
       list3.add(100);
       list3.add(101);
       list3.add(102);
        
       List list4 = new List();
       list4.add(100);
       
       list1.selectionSort();
       list2.selectionSort();
       list3.selectionSort();
       list4.selectionSort();

// Test #1   
      if( list1.toString().equals("1->2->3->4->5->6") && list2.toString().equals("101->102") && list3.toString().equals("100->101->102") && list4.toString().equals("100")) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 05 selectionSort() - regular functionality",  "PASSED");
           count++;
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 05 selectionSort() - regular functionality",  "FAILED");

//Test #2 
       List list5 = new List();
       list5.selectionSort();
      if(list5.isEmpty()) 
       {
           outputStream.printf("%-80s%-10s\r\n", "TEST SET 05 selectionSort() - empty list",  "PASSED");
           count++;
       }
       else outputStream.printf("%-80s%-10s\r\n", "TEST SET 05 selectionSort() - empty list",  "FAILED");

      return count==expectedCount;
   }
	
	
}
