package Stack;

import java.util.Stack;

import java.util.Scanner;

 class reverse_num {

    public static void main(String[] args) {

        // creating an instance of Stack class

        Stack<Integer> stk = new Stack<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the number to be reversed :");

        int num = sc.nextInt();

        int rev_num = 0, digit = 0, power = 0;

        while (num != 0) {

            //pushing each digit into the stack

            digit = num % 10;

            stk.push(digit);

            num = num / 10;

        }

        System.out.println("Elements in Stack: " + stk);

        while (!stk.isEmpty()) {

            digit = stk.pop();

            //Multiplying the popped digit with suitable power of 10 and adding.

            rev_num = rev_num + digit * (int) Math.pow(10, power);

            power = power + 1; //increasing the power to which 10 has to be raised

        }

        System.out.println("The reversed number is : " + rev_num);

    }
}