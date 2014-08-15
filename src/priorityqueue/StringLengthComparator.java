// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package priorityqueue;

import java.util.Comparator;

/**
 * This program will take series of input strings and send them
 * to the priority queue function and there it will be sorted
 * as per their string length,
 * We can take any parameter as priority there.
 * This class will take care of the comparison into the priority
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-15
 */

public class StringLengthComparator implements Comparator<String>
{
 @Override
 public int compare(String x, String y)
 {

     if (x.length() < y.length())
     {
         return -1;
     }
     else if (x.length() > y.length())
     {
         return 1;
     }
     else{
    	 return 0;
     }
 }
}