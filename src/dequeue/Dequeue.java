// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package dequeue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * Here it is a Double ended Queue. where items can be added or removed
 * from both end.
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-15
 */


public class Dequeue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deque<String> dequeA = new LinkedList<String>();

		dequeA.add("element 0");
		dequeA.add("element 1");
		dequeA.add("element 2");

		//access via Iterator
		Iterator<String> iterator = dequeA.iterator();
		
		while(iterator.hasNext()){
		  String element = (String) iterator.next();
		  System.out.println(element);
		}

		System.out.println("----");

		Object firstElement = dequeA.remove();
		System.out.println("removed : " + firstElement);
		Object lastElement  = dequeA.removeLast();
		System.out.println("removed : " + lastElement);
		
		System.out.println("----");

		//access via new for-loop
		for(Object object : dequeA) {
		    String element = (String) object;
		    System.out.println(element);
		}


	}

}
