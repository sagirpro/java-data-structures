// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * This program will take series of input strings and send them
 * to the priority queue function and there it will be sorted
 * as per their string length,
 * We can take any parameter as priority there.
 * Operator will manage the call for the priority Queue.
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-15
 */


public class Operator
{
public static void main(String[] args)
{
   Comparator<String> comparator = new StringLengthComparator();
   PriorityQueue<String> queue = new PriorityQueue<String>(10, comparator);
   
   queue.add("I am very happy");
   queue.add("sad");
   queue.add("I am feeling awesome ! wow !");
   System.out.println("Here is the priority output <> based on the size of the string : ");
   while (queue.size() != 0)
   {
       System.out.println(queue.remove());
   }
}
}
