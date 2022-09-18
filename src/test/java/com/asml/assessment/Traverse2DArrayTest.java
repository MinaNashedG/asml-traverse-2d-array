package com.asml.assessment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Traverse2DArrayTest {

	@ParameterizedTest
	@MethodSource
	public void should_traverse_and_print_elements(Integer[][] input, String expected) {
		Assertions.assertEquals(expected, Traverse2DArray.traverse(input));
	}

	@Test
	public void should_not_throw_memory_exception() {
		Assertions.assertNotNull(Traverse2DArray.traverse(testCase15()));
	}

	private static Stream<Arguments> should_traverse_and_print_elements() {
		return Stream.of(
				Arguments.of(testCase1(), "1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10"),
				Arguments.of(testCase2(), "1,2,3,4,8,7,6,5"),
				Arguments.of(testCase3(), "1,2,3,4"),
				Arguments.of(testCase4(), "1,2,3,4,8,12,11,10,9,5,6,7"),
				Arguments.of(testCase5(), "1,2,3,4,8,12,16,20,19,18,17,13,9,5,6,7,11,15,14,10"),
				Arguments.of(testCase6(), "1,2,3,7,11,10,9,5,6"),
				Arguments.of(testCase7(), "1,2,3,7,11,14,13,12,9,5,6,10"),
				Arguments.of(testCase8(), "1,2,3,7,11,14,17,21,20,19,15,12,9,5,6,10,13,16"),
				Arguments.of(testCase9(), "1,2,3,7,6,5"),
				Arguments.of(testCase10(), "1,2,4,6,8,7,5,3"),
				Arguments.of(testCase11(), "1,2,4,3"),
				Arguments.of(testCase12(), "1,2"),
				Arguments.of(testCase13(), "1,2,3,4,5,6,7,8,9,10,10,9,8,7,6,5,4,3,2,1"),
				Arguments.of(testCase14(), expected()),
				Arguments.of(new Integer[][]{}, ""),
				Arguments.of(null, "")
		);
	}

	private static String expected() {
		return IntStream.rangeClosed(1, 60).boxed().map(String::valueOf).collect(
				Collectors.joining(","));
	}

	private static Integer[][] testCase1() {
		return new Integer[][]{
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}};
	}

	private static Integer[][] testCase4() {
		return new Integer[][]{
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}};
	}

	private static Integer[][] testCase2() {
		return new Integer[][]{
				{1, 2, 3, 4},
				{5, 6, 7, 8}};
	}

	private static Integer[][] testCase3() {
		return new Integer[][]{
				{1, 2, 3, 4}
		};
	}

	private static Integer[][] testCase5() {
		return new Integer[][]{
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
				{17, 18, 19, 20}};
	}

	private static Integer[][] testCase6() {
		return new Integer[][]{
				{1, 2, 3},
				{5, 6, 7},
				{9, 10, 11}
		};
	}

	private static Integer[][] testCase7() {
		return new Integer[][]{
				{1, 2, 3},
				{5, 6, 7},
				{9, 10, 11},
				{12, 13, 14}
		};
	}

	private static Integer[][] testCase8() {
		return new Integer[][]{
				{1, 2, 3},
				{5, 6, 7},
				{9, 10, 11},
				{12, 13, 14},
				{15, 16, 17},
				{19, 20, 21}
		};
	}

	private static Integer[][] testCase9() {
		return new Integer[][]{
				{1, 2, 3},
				{5, 6, 7}
		};
	}

	private static Integer[][] testCase10() {
		return new Integer[][]{
				{1, 2},
				{3, 4},
				{5, 6},
				{7, 8}
		};
	}

	private static Integer[][] testCase11() {
		return new Integer[][]{
				{1, 2},
				{3, 4}
		};
	}

	private static Integer[][] testCase12() {
		return new Integer[][]{
				{1},
				{2}
		};
	}

	private static Integer[][] testCase13() {
		return new Integer[][]{
				{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
				{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		};
	}

	private static Integer[][] testCase14() {
		return new Integer[][]{
				{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
				{28, 29, 30, 31, 32, 33, 34, 35, 36, 11},
				{27, 48, 49, 50, 51, 52, 53, 54, 37, 12},
				{26, 47, 60, 59, 58, 57, 56, 55, 38, 13},
				{25, 46, 45, 44, 43, 42, 41, 40, 39, 14},
				{24, 23, 22, 21, 20, 19, 18, 17, 16, 15}
		};
	}

	private static Integer[][] testCase15() {
		final int numberOfRowsAndCols = 1000;
		Integer[][] testData = new Integer[numberOfRowsAndCols][numberOfRowsAndCols];
		for (int i = 0; i < numberOfRowsAndCols; i++) {
			for (int j = 0; j < numberOfRowsAndCols; j++) {
				testData[i][j] = 1;
			}
		}
		return testData;
	}

}