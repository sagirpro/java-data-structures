// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package hash;

import java.util.HashMap;

/**
 * Using HashMap package we just fetched simple data manually stored
 * in the map. HashMap allows different types of data to create a
 * new.
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-09
 */

public class HashMapPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> performance = new HashMap<String, Integer>();
		
		performance.put("Apple", 44000);
		performance.put("Blackberry", 29000);
		performance.put("Nexus", 32500);
		performance.put("Windows Phone", 9000);
		performance.put("Mozilla", 5000);
		
		
		int priceofBB = performance.get("Blackberry");
		System.out.println("Here is the price of Blackberry " + priceofBB);

	}

}
