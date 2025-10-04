//Dsa day 6
//topics covered HashTable, Math,Two Pointers

import java.util.*;
class HappyNumber {

    // Function to check happy number
    public static boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
//following loop will print the squares of digits and their sum at each step
        
            while (n != 1 && !seen.contains(n)) {
            seen.add(n);

            int temp = n;
            int sum = 0;

            //Here iteration will take place until temp becomes 0
            System.out.print("Digits squares: ");
            while (temp > 0) {
                int digit = temp % 10;
                int digitSquare = digit * digit;
                sum += digitSquare;
                System.out.print(digitSquare + "+"); // print square of each digit
                temp /= 10; //Removing last digit and Again going for iteration until temp becomes 0
            }

            n = sum;
            System.out.println("=> Sum: " + sum); // print sum of squares
        }

        if (n == 1) {
            System.out.println("Happy Number");
            return true;
        } else {
            System.out.println("Not a Happy Number");
            return false;
        }
    }

    // Main method
    public static void main(String[] args) {
        int n1 = 19;
        int n2 = 2;

        System.out.println("Checking " + n1 + ":");
        isHappy(n1);
        System.out.println();

        System.out.println("Checking " + n2 + ":");
        isHappy(n2);
    }
}
