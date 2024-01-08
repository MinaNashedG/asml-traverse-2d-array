package com.asml.assessment;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mina
 * Traverse2DArray A class for travering 2D array and return traversed elements as String
 */
public class Traverse2DArray {

	/**
	 * Comma Delimiter.
	 */
	private static final String DELIMITER = ",";
	/**
	 * Default EMPTY String.
	 */
	private static final String EMPTY = "";

	/**
	 * Traverse 2D input array and return traversed elements as String.
	 *
	 * @param input2dArray is a 2D array ,for example {{1,2,3},{4,5,6}}.
	 * @return EMPTY if the 2D array param is null or empty, otherwise return traversed elements as String
	 */
	public static String traverse(Integer[][] input2dArray) {
		// Check if the input 2d array is null or empty.
		if (input2dArray == null || input2dArray.length == 0) {
			return EMPTY;
		}
		// Define and Initialize the boundary of the 2d array.
		int topRow = 0, leftCol = 0;
		int bottomRow = input2dArray.length - 1, rightCol = input2dArray[0].length - 1;

		// List for adding traversed elements.
		List<Integer> result = new ArrayList<>();

		while (topRow <= bottomRow && leftCol <= rightCol) {
			int startColIndex = leftCol, endColIndex = rightCol - 1;
			int startRowIndex = topRow + 1, endRowIndex = bottomRow - 1;

			//This Loop for traversing from left to right.
			while (startColIndex <= rightCol) {
				result.add(input2dArray[topRow][startColIndex]);
				startColIndex++;
			}

			//This Loop for traversing from top to down.
			while (startRowIndex <= bottomRow) {
				result.add(input2dArray[startRowIndex][rightCol]);
				startRowIndex++;
			}

			//This Loop for traversing from right to left.
			while (endColIndex >= leftCol && topRow != bottomRow) {
				result.add(input2dArray[bottomRow][endColIndex]);
				endColIndex--;
			}

			//This Loop for traversing from down to top.
			while (endRowIndex > topRow && leftCol != rightCol) {
				result.add(input2dArray[endRowIndex][leftCol]);
				endRowIndex--;
			}
			leftCol++;
			topRow++;
			rightCol--;
			bottomRow--;
		}
		return printResult(result);
	}

	/**
	 * @param result is a list of traversed elements.
	 * @return traversed elements as String.
	 */
	private static String printResult(List<Integer> result) {
		return StringUtils.join(result, DELIMITER);
	}
}
