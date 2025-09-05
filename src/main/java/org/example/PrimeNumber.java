package org.example;

public class PrimeNumber {

    public static void main(String[] args) {
        int input = 9;
       boolean val =  checkPrime(input);
        System.out.println(val);
    }

    private static boolean checkPrime(int input) {
        boolean flag = true;
        if(input<0)
            return false;

        if(input == 1 || input == 2)
            return true;

        for(int i =2 ; i<=input/2; i++){
            if(input%i==0){
                flag = false;
                return false;
            }
        }
        return flag;
    }
}
