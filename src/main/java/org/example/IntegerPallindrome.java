package org.example;

public class IntegerPallindrome {

    public static void main(String[] args) {
        int input = 121;

        boolean b = checkIntPallindrome(input);
        System.out.println(b);
    }

    private static boolean checkIntPallindrome(int input) {

        //int remainder = input%10;
        int pallindrome = input;
        int reverse = 0;

        while (pallindrome!=0){
            int remainder = pallindrome%10;
            reverse = reverse*10 + remainder;
            pallindrome = pallindrome/10;
        }
        if(reverse==input){
            return true;
        }
        return false;
    }
}
