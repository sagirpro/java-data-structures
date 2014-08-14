// =============================================================================
//	Apache License
//	Version 2.0, January 2004
//	http://www.apache.org/licenses/
// =============================================================================

package adjacencymatrix;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This will take Adjacency matrix as input and then it will
 * fetch all the connected link from row to column according
 * to the given row number
 * 
 * @author Sagir <sagir.pro@gmail.com>
 * @since 2014-08-09
 */

public class RowColumnRelation {


	private static Scanner in;

	public static void main(final String[] args) {

		int rowNumber, columnNumber, rowToFollow;
		in = new Scanner(System.in);

		System.out.println("Enter the number of rows and columns of matrix");
		rowNumber = in.nextInt();
		columnNumber = in.nextInt();

		final int first[][] = new int[rowNumber][columnNumber];
		final ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("Enter the elements of first matrix");

		for (int c = 0; c < rowNumber; c++)
			for (int d = 0; d < columnNumber; d++)
				first[c][d] = in.nextInt();

		System.out.println("Given Matrix is:-");

		for (int c = 0; c < rowNumber; c++) {
			for (int d = 0; d < columnNumber; d++)
				System.out.print(first[c][d] + "\t");
			System.out.println();
		}

		System.out.println("Please give the row number");
		rowToFollow = in.nextInt();

		for (int c = 0; c < rowNumber; c++) {
			for (int d = 0; d < columnNumber; d++) {
				if (c == (rowToFollow - 1) && first[c][d] == 1){
					System.out.println("R" + (c + 1) + "-> C" + (d + 1));
					list.add(d);
				}
			}
			System.out.println();
		}

		for (final Integer column : list) {
			for (int c = 0; c < rowNumber; c++) {
				for (int d = 0; d < columnNumber; d++) {
					if (d == (column) && first[c][d] == 1) {
						System.out.println("C" + (d + 1) + "-> R" + (c + 1));
					}
				}
				System.out.println();
			}

		}

	}
}
