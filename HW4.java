// Assignment: 4
// Author: Liav Lugasi, ID: 213007271

package introtocsHW4;

/**
 * Assignment 4 - Recursion Practice.
 * This class contains various recursive solutions for array manipulation,
 * string processing, mathematical computations, and matrix operations.
 */

public class HW4 {

    // Question 1
    /**
     * Finds the maximum value in an integer array.
     * * @param arr The array of integers to search.
     * @return The maximum integer found in the array.
     */

    public static int FindMax(int[] arr) {
        return FindMaxHelper(arr, 0);
    }

    private static int FindMaxHelper(int[] arr, int i) {
        if (i == arr.length - 1) {
            return arr[i];
        }
        int maxNum = FindMaxHelper(arr, i + 1);            // Compare current element
        return Math.max(arr[i], maxNum);                     // with max of the rest
    }

    //Question2

    /**
     * Checks if a string is a palindrome.
     * A palindrome reads the same forwards and backwards.
     * * @param str The string to check.
     * @return true if the string is a palindrome, false otherwise.
     */

    public static boolean IsPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }
        return IsPalindromeHelper(str, 0, str.length() - 1);
    }

    private static boolean IsPalindromeHelper(String str, int x, int y) {
        if (x >= y) {
            return true;
        }

        if (str.charAt(x) != str.charAt(y)) {          // If chars at ends don't match - not a palindrome
            return false;
        }

        return IsPalindromeHelper(str, x + 1, y - 1);
    }

    //Question 3

    /**
     * Searches for a specific word within a text.
     * The search is case-insensitive and ensures the word is a standalone word
     * (not part of another word) by checking surrounding characters.
     * * @param text The text to search within.
     * @param word The word to search for.
     * @return true if the word is found as a separate entity, false otherwise.
     */

    public static boolean SearchWord(String text, String word) {
        if (text.length() < word.length()) {                // If remaining text is shorter than the word
            return false;
        }
        return SearchWordHelper(text.toLowerCase(), word.toLowerCase(), 0);
    }

    private static boolean SearchWordHelper(String text, String word, int i) {
        if (i + word.length() > text.length()) {
            return false;
        }

        String subText = text.substring(i, i + word.length());
        boolean isMatch = subText.equals(word);

        if (isMatch) {                                              // Check boundaries (ensure it's a separate word)
            boolean leftOk = (i == 0) || !Character.isLetter(text.charAt(i - 1));
            boolean rightOk = (i + word.length() == text.length()) ||
                    !Character.isLetter(text.charAt(i + word.length()));

            if (leftOk && rightOk) {
                return true;
            }
        }
        return SearchWordHelper(text, word, i + 1);     // Try searching from next index
    }

    //Question 4

    /**
     * Extracts characters located at odd indices of a string.
     * * @param str The original string.
     * @return A string containing characters from indices 1, 3, 5, etc.
     */

    public static String GetOddIndexLetters(String str) {
        return GetOddIndexLettersHelper(str, 1);                   // Start from index 1
    }

    private static String GetOddIndexLettersHelper(String str, int i) {
        if (i >= str.length()) {
            return "";
        }
        return str.charAt(i) + GetOddIndexLettersHelper(str, i + 2);        // Concat current char and jump by 2
    }

    //Question 5

    /**
     * Determines if n is a power of m (n = m^k).
     * * @param n The number to check.
     * @param m The base.
     * @return true if n is a power of m, false otherwise.
     */

    public static boolean IsPower(int n, int m) {
        if (n == 1) {
            return true;
        }

        if (m == 1) {
            return false;
        }

        return isPowerHelper(n, m);
    }

    private static boolean isPowerHelper(int newN, int m) {
        if (newN == 1) {
            return true;
        }

        if (newN % m != 0 || newN == 0) {       // If there is a remainder or number becomes 0
            return false;
        }

        return isPowerHelper(newN / m, m);
    }

    //Question 6

    /**
     * Calculates the determinant of a square matrix recursively using Laplace expansion.
     * * @param matrix A 2D square array of integers.
     * @return The determinant of the matrix.
     */

    public static int Determinant(int[][] matrix) {
        int n = matrix.length;

        // Base cases: 1x1 or 2x2 matrix
        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        int sum = 0;

        for (int col = 0; col < n; col++) {
            int[][] subMatrix = DeterminantHelper(matrix, col);
            int x = (col % 2 == 0) ? 1 : -1;                         //short if: col%2 == 0? if true: 1 , else: -1.
            sum += x * matrix[0][col] * Determinant(subMatrix);
        }

        return sum;
    }

    /**
     * Helper method to generate a sub-matrix by removing the first row and a specific column.
     * * @param matrix The original matrix.
     * @param col The column index to exclude.
     * @return A new (n-1)x(n-1) matrix.
     */

    public static int[][] DeterminantHelper(int[][] matrix, int col) {
        int n = matrix.length;
        int[][] newMat = new int[n - 1][n - 1];
        int colIndex;

        for (int i = 1; i < n; i++) {
            colIndex = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) {                 // Skip the column to remove
                    continue;
                }
                newMat[i - 1][colIndex] = matrix[i][j];
                colIndex++;
            }
        }
        return newMat;
    }

    //Question 7

    /**
     * Solves the Subset Sum problem: checks if any combination of numbers
     * in the array adds up exactly to the target sum.
     * * @param arr The array of integers.
     * @param sum The target sum.
     * @return true if a subset exists that equals the sum, false otherwise.
     */

    public static boolean SubsetSum(int[] arr, int sum) {
        return subsetSumHelper(arr, sum, 0);
    }

    private static boolean subsetSumHelper(int[] arr, int orginalSum, int i) {

        if (orginalSum == 0) {                              // Reached target sum
            return true;
        }

        if (i == arr.length || orginalSum < 0) {           // Out of bounds or sum negative
            return false;
        }

        // Two options: take current number or skip it
        boolean take = subsetSumHelper(arr, orginalSum - arr[i], i + 1);
        boolean dontTake = subsetSumHelper(arr, orginalSum, i + 1);
        return take || dontTake;
    }

    //Question 8

    /**
     * Calculates the n-th element of the Tribonacci sequence.
     * The sequence is defined as: T(0)=0, T(1)=0, T(2)=1, and T(n) = T(n-1) + T(n-2) + T(n-3).
     * * @param n The index of the element.
     * @return The value of the n-th Tribonacci element.
     */

    public static  int TribonacciElement(int n){
        if (n == 0 || n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        return TribonacciElementHelper(n,0,0,1);
    }

    private static  int TribonacciElementHelper(int n,int a, int b,int c){
        if (n == 0) {
            return a;
        }
        return TribonacciElementHelper(n - 1, b, c, a + b + c);     // Advance vars: a gets b, b gets c, c gets sum
    }

    //Question 9

    /**
     * Generates an array containing the first n elements of the Tribonacci sequence.
     * Uses memoization to optimize calculation time.
     * * @param n The number of elements to generate.
     * @return An array containing the sequence up to n.
     */

    public static int[] TribonacciSequence(int n) {
        if (n <= 0) {
            return new int[0];
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {                        // Init with -1 to know which values aren't calculated
            arr[i] = -1;
        }

        TribonacciSequenceHelper(arr, n - 1);
        return arr;
    }

    private static int TribonacciSequenceHelper(int[] arr, int i) {
        if (i < 0){
            return 0;
        }

        if (arr[i] != -1) {           // If calculated, return from array
            return arr[i];
        }

        if (i == 0 || i == 1) {
            arr[i] = 0;
            return 0;
        }

        if (i == 2) {
            arr[i] = 1;
            return 1;
        }

        // Calculate and save in array for later
        arr[i] = TribonacciSequenceHelper(arr, i - 1) + TribonacciSequenceHelper(arr, i - 2) + TribonacciSequenceHelper(arr, i - 3);

        return arr[i];
    }

    //Question 10

    /**
     * Counts the total number of prime factors for a given integer.
     * For example, for n=12 (2*2*3), the result is 3.
     * * @param n The number to factorize.
     * @return The count of prime factors.
     */

    public static int PrimeFactors(int n) {
        if (n <= 1) {
            return 0;
        }

        return PrimeFactorsHelper(n, 2);
    }

    private static int PrimeFactorsHelper(int orgN, int d) {
        if (orgN == 1) {
            return 0;
        }

        if (orgN % d == 0) {                             // If divisible by d, add 1 to count and keep dividing by d
            return 1 + PrimeFactorsHelper(orgN / d, d);
        }
        else {
            return PrimeFactorsHelper(orgN, d + 1);               // If not divisible, move to next divisor
        }
    }
}