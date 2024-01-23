package org.fasttrackit.homework;

public class Homework {
    public static void main(String[] args) {

        System.out.println(sumOfEvenNumbers(5));

        // suma pana la n a numerelor pare -> daca n = 5 -> 0 + 2 + 4
        // suma primelor n numere pare -> daca n = 5 -> 0 + 2 + 4 + 6 + 8

        boolean isPalindrom = palindrom("madam");
        System.out.println(isPalindrom);
    }

    private static boolean palindrom(String input) {
        if (input.length() < 2) {
            return true;
        }

        char leftChar = input.charAt(0);
        char rightChar = input.charAt(input.length() - 1);
        boolean extremitiesAreEqual = leftChar == rightChar;
        return extremitiesAreEqual && palindrom(input.substring(1, input.length() - 1));
    }

    private static int sumOfEvenNumbers(int input) {
        if (input == 0) {
            return 0;
        }

        return (input % 2 != 0 ? 0 : input) + sumOfEvenNumbers(input - 1);
        // n = 5 -> 0 + 4 + 0 + 2 + 0 + 0
    }
}
