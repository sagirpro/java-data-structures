// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package redblack;

import java.util.TreeMap;

/**
 * Red Black tree can be represented as a TreeMap in java. This package is come
 * inside the util class and optimized as it supports by the oracle.
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-16
 * 
 */

public class TreeMapRedBlack {
	public static void main(String[] args) {
		// creating tree map
		TreeMap<String, String> treemap = new TreeMap<String, String>();

		// populating tree map
		treemap.put("mobOs1", "Android");
		treemap.put("mobOs2", "ios8");
		treemap.put("mobOs3", "wp8");
		treemap.put("computerOs1", "os10");
		treemap.put("computerOs2", "windows 8");

		// printing specific entry
		System.out.println("Ceiling entry for computerOs2: "
				+ treemap.ceilingEntry("computerOs2"));
		System.out.println("Ceiling entry for computerOs1: "
				+ treemap.ceilingEntry("computerOs1"));

		System.out.println("-------");

		// printing specific value against a key
		System.out.println("Checking value for key computerOs1");
		System.out.println("Value is: " + treemap.get("computerOs1"));

		System.out.println("-------");

		System.out.println("Cloning tree map");
		@SuppressWarnings("unchecked")
		TreeMap<String, String> treemapclone = (TreeMap<String, String>) treemap
				.clone();

		System.out.println("Original map: " + treemap);
		System.out.println("Cloned map: " + treemapclone);

		System.out.println("-------");

		System.out.println("Entries in the Map: " + treemap);

		// clearing the map
		System.out.println("Clearing the Map");
		treemap.clear();

		System.out.println("\nEntries in the Map: " + treemap);
	}
}
