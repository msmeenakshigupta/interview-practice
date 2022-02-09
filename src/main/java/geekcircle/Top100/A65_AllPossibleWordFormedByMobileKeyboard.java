package com.geekcircle.Top100;

import java.util.Arrays;
import java.util.List;

public class A65_AllPossibleWordFormedByMobileKeyboard {
    public static void main(String[] args) {
        List<List<Character>> keypad = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList( 'A', 'B', 'C' ),
                Arrays.asList( 'D', 'E', 'F' ),
                Arrays.asList( 'G', 'H', 'I' ),
                Arrays.asList( 'J', 'K', 'L' ),
                Arrays.asList( 'M', 'N', 'O' ),
                Arrays.asList( 'P', 'Q', 'R', 'S'),
                Arrays.asList( 'T', 'U', 'V' ),
                Arrays.asList( 'W', 'X', 'Y', 'Z')
        );

        int[] input = { 2, 3, 4 };

        findCombinations(keypad, input, "", input.length - 1);
    }

    private static void findCombinations(List<List<Character>> keypad, int[] input, String str, int n){
        if(n == -1){
            System.out.println(str);
            return;
        }

        for(Character c : keypad.get(input[n])){
            findCombinations(keypad, input, c+str, n-1);
        }
    }
}
