package ar.edu.itba.eda.algorithms;

import java.util.HashMap;
import java.util.Map;

public class Soundex {

    private static Map<Character, Character> ENCODING_TABLE = new HashMap<Character, Character>(){
        {
         put('A', '0');
         put('E', '0');
         put('I', '0');
         put('O', '0');
         put('U', '0');
         put('Y', '0');
         put('W', '0');
         put('H', '0');
         put('B', '1');
         put('F', '1');
         put('P', '1');
         put('V', '1');
         put('C', '2');
         put('G', '2');
         put('J', '2');
         put('K', '2');
         put('Q', '2');
         put('S', '2');
         put('X', '2');
         put('Z', '2');
         put('D', '3');
         put('T', '3');
         put('L', '4');
         put('M', '5');
         put('N', '5');
         put('R', '6');
        }
    };

    public static String encode(String inputString){
        char[] inputArray = inputString.toCharArray();
        char[] outputArray = {'0', '0', '0', '0'};
        outputArray[0] = Character.toUpperCase(inputArray[0]);
        int currentIndex = 1;
        char last = encodeChar(outputArray[0]);
        for (char inputCharacter: inputArray) {
            char encodedInputCharacter = encodeChar(inputCharacter);
            if (encodedInputCharacter != '0' && encodedInputCharacter != last){
                inputArray[currentIndex] = encodedInputCharacter;
                currentIndex++;
            }
            last = encodedInputCharacter;
            if(currentIndex == 4)
                break;
        }
        return new String(outputArray);
    }

    private static char encodeChar(char inputCharacter){
        Character characterToEncode = Character.toUpperCase(inputCharacter);
        System.out.println(characterToEncode);
        System.out.println(ENCODING_TABLE.get(characterToEncode));
        return ENCODING_TABLE.get(characterToEncode);
    }

}
