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
	 * @param input2dArray is a 2D array ,for example {{1,2,3},{4,5,6}}.
	 * @return EMPTY if the 2D array param is null or empty, otherwise return traversed elements as String
	 */
	public static String traverse(Integer[][] input2dArray) {
		// Check if the input 2d array is null or empty.
		if (input2dArray == null || input2dArray.length == 0) {
			return EMPTY;
		}
		// Check if there is only one row in the given 2d array.
		if (input2dArray.length == 1) {
			return printResult(Arrays.asList(input2dArray[0]));
		}
		// Define and Initialize the boundary of the 2d array.
		int beginRow = 0, beginCol = 0;
		int endRow = input2dArray.length - 1, endCol = input2dArray[0].length - 1;

		// List for adding traversed elements.
		List<Integer> result = new ArrayList<>();

		while (beginRow <= endRow && beginCol <= endCol) {
			int startColIndex = beginCol, startRowIndex = beginRow + 1;
			int endRowIndex = endRow - 1, endColIndex = endCol - 1;

			//This Loop for traversing the first row from left to right.
			while (startColIndex <= endCol) {
				result.add(input2dArray[beginRow][startColIndex]);
				startColIndex++;
			}

			//This Loop for traversing the last column from top to down.
			while (startRowIndex <= endRow) {
				result.add(input2dArray[startRowIndex][endCol]);
				startRowIndex++;
			}

			//This Loop for traversing the last row from right to left.
			while (endColIndex >= beginCol && beginRow != endRow) {
				result.add(input2dArray[endRow][endColIndex]);
				endColIndex--;
			}

			//This Loop for traversing the first column from down to top.
			while (endRowIndex > beginRow && beginCol != endCol) {
				result.add(input2dArray[endRowIndex][beginCol]);
				endRowIndex--;
			}
			beginCol++;
			beginRow++;
			endCol--;
			endRow--;
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
