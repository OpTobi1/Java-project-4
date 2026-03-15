// Assignment: 4
// Author: Liav Lugasi, ID: 213007271

package introtocsHW4;

public class HW4tests {

    public static void main(String[] args) {
        // Task 1: Largest Number
        int[] arr1 = {8, 4, 12, 32, 3};
        int[] arr2 = {15, 25, 10, 25};
        int[] arr3 = {5, 5, 5, 5};
        System.out.println("Task 1: Second Largest Number");
        System.out.println(HW4.FindMax(arr1) == 32);
        System.out.println(HW4.FindMax(arr2) == 25);
        System.out.println(HW4.FindMax(arr3) == 5);

        // Task 2: Palindrome
        System.out.println("\nTask 2: Palindrome");
        System.out.println(HW4.IsPalindrome("racecar") == true);
        System.out.println(HW4.IsPalindrome("hello") == false);
        System.out.println(HW4.IsPalindrome("12321") == true);
        System.out.println(HW4.IsPalindrome("a") == true);
        System.out.println(HW4.IsPalindrome("") == true);

        // Task 3: Word Search (Case Insensitive)
        System.out.println("\nTask 3: Word Search");
        System.out.println(HW4.SearchWord("Hello World", "world") == true);
        System.out.println(HW4.SearchWord("Java is fun!", "JAVA") == true);
        System.out.println(HW4.SearchWord("Programming with Python", "python") == true);
        System.out.println(HW4.SearchWord("case sensitivity", "sensitivity") == true);
        System.out.println(HW4.SearchWord("", "test") == false);

        // Task 4: Odd Index Letters
        System.out.println("\nTask 4: Odd Index Letters");
        System.out.println(HW4.GetOddIndexLetters("world Hello").equals("ol el"));
        System.out.println(HW4.GetOddIndexLetters("abcdef").equals("bdf"));
        System.out.println(HW4.GetOddIndexLetters("123456789").equals("2468"));

        // Task 5: Power Check
        System.out.println("\nTask 5: Power Check");
        System.out.println(HW4.IsPower(8, 2) == true);
        System.out.println(HW4.IsPower(6, 3) == false);
        System.out.println(HW4.IsPower(125, 5) == true);

        // Task 6: Determinant Calculation
        int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] m2 = {
                {1, 0, 2, -1},
                {3, 0, 0, 5},
                {2, 1, 4, -3},
                {1, 0, 5, 0}
        };
        int[][] m3 = {{2, 5}, {1, 3}};
        int[][] m4 = {{4, 7}, {2, 6}};
        int[][] m5 = {{1, 2, 3}, {0, 1, 4}, {5, 6, 0}};
        int[][] m6 = {{3, 1}, {5, 2}};
        int[][] m7 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        System.out.println("\nTask 6: Determinant");
        System.out.println(HW4.Determinant(m1) == 0);
        System.out.println(HW4.Determinant(m2) == 30);
        System.out.println(HW4.Determinant(m3) == 1);
        System.out.println(HW4.Determinant(m4) == 10);
        System.out.println(HW4.Determinant(m5) == 1);
        System.out.println(HW4.Determinant(m6) == 1);
        System.out.println(HW4.Determinant(m7) == 0);

        // Task 7: Subset Sum
        int[] subsetArr1 = {6, 97, 15, 8, 3};
        int[] subsetArr2 = {3, 12, 2, 87, 5, 4};
        System.out.println("\nTask 7: Subset Sum");
        System.out.println(HW4.SubsetSum(subsetArr1, 9) == true);
        System.out.println(HW4.SubsetSum(subsetArr2, 13) == false);

        // Task 8: Tribonacci Element
        System.out.println("\nTask 8: Tribonacci Element");
        System.out.println(HW4.TribonacciElement(10) == 81);
        System.out.println(HW4.TribonacciElement(5) == 4);

        // Task 9: Tribonacci Sequence
        System.out.println("\nTask 9: Tribonacci Sequence");
        int[] tribSeq = HW4.TribonacciSequence(10);
        int[] expectedSeq = {0, 0, 1, 1, 2, 4, 7, 13, 24, 44};
        System.out.println(java.util.Arrays.equals(tribSeq, expectedSeq));

        // Task 10: Prime Factors
        System.out.println("\nTask 10: Prime Factors");
        System.out.println(HW4.PrimeFactors(60) == 4);
        System.out.println(HW4.PrimeFactors(17) == 1);
        System.out.println(HW4.PrimeFactors(100) == 4);
        System.out.println(HW4.PrimeFactors(96) == 6);
        }

}
