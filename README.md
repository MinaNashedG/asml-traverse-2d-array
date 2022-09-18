# ASML Traverse 2D Array


## Requirements
```
Given a 2D array

{{1,2,3,4}
{5,6,7,8},
{9,10,11,12},
{13,14,15,16}}

Traverse the array in the pattern below and print the numbers along the path.
output: 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10

```
### Algorithm Complexity
```
Time Complexity: O(N*M), where N (number of rows) and M (number of columns).
Space Complexity: O(N*M).
```
## Solution Explanation
```
To traverse elements into 2D matrix , we had to create 4 pointers 

BEGIN step:

    1. topRow : point to the first row index in the matrix.
    2. bottomRow : point to the last row index in the matrix.
    3. leftCol : point to the first column index in the matrix.
    2. rightCol : point to the last column index in the matrix.
    
LOOP step: topRow <= bottomRow && leftCol <= rightCol

1st step: loop and go through elements from left coloum to right column.
2nd step: loop and go through elements from top row to bottom row.
3nd step: loop and go through elements from right coloum to left column.
4th step: loop and go through elements from bottom row to top row.
5th step: increment the pointers for rightCol, topRow and decrement
          the pointers for leftCol , bottomRow .
6th step : Goto LOOP step.
    
```
### Dependencies

Java version: 11

Maven version: 3.8

Junit : 5


## Run Test Cases

```
# to run all unit tests.
$ mvn clean test
```

## Suggestion for improvement

I suggest to use DFS with recursion for improvement .
