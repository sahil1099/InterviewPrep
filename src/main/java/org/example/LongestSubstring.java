package org.example;

public class LongestSubstring {
    public static void main(String[] args) {
        int longest = 1;
        int currentCharLength = 1;
        String s = "aaskkkaaaaa";
        char[] charArray = s.toLowerCase().toCharArray();
        char current = charArray[0];
        char maxChar = current;
        for(int i =1; i<charArray.length ; i++){
            if(charArray[i] == current){
                currentCharLength++;
            }else{
                if(currentCharLength>longest){
                    longest = currentCharLength;
                    maxChar = current;
                }
                currentCharLength = 1;
                current = charArray[i];
            }
        }
        if(currentCharLength>longest){
            longest = currentCharLength;
            maxChar = current;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int j =0 ; j<longest ; j++){
            stringBuilder.append(maxChar);
        }

        System.out.println(stringBuilder.toString());
    }
}
