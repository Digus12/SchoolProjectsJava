import java.util.Stack;

import java.util.Scanner;

public class StringReverser {

    public static void main(String args[]) {

        Stack<String> stk = new Stack<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the strings to be reversed (Enter -1 in the end): ");

        String word = "", rev_str = "", str = "";

        while (sc.hasNext()) {

            word = "";// taking each word of the input

            str = "";

            // while loop to stop pushing elements once "." is reached.

            while (!((word = sc.next()).equals(".")) & !(word).equals("-1")) {

                stk.push(word);

            }

            // When word reads -1, the while loop breaks

            if (word.equals("-1")) {

                break;

            }

            while (!stk.isEmpty()) {

                // concatenating the popped words into a string.

                // All the words will be in lower case.

                str = str + stk.pop().toLowerCase() + " ";

            }

            // Adding each reversed string to the final string.

            rev_str = rev_str + str.substring(0, 1).toUpperCase() + str.substring(1) + ". ";

        }

        System.out.println("\nReversed string: \n");

        System.out.println(rev_str + "\n");

    }