package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(romanToInt("MDCLXXVIII"));
    }

    public static int romanToInt(String s){
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        dictionary.put("I", 1);
        dictionary.put("V", 5);
        dictionary.put("X", 10);
        dictionary.put("L", 50);
        dictionary.put("C", 100);
        dictionary.put("D", 500);
        dictionary.put("M", 1000);

        int lenght_s = String.valueOf(s).length();
        int result = 0;
        String current_character = "";
        String previous_character = "";
        for (int i = 0; i < lenght_s; i++){
            current_character = s.substring(i, i+1);
            if (i != 0){previous_character = s.substring(i-1, i);}
            if (i != 0 && ((previous_character + current_character).equals("IV") || (previous_character + current_character).equals("IX")) || (previous_character + current_character).equals("XL") || (previous_character + current_character).equals("XC") || (previous_character + current_character).equals("CD") || (previous_character + current_character).equals("CM")){
                if ((previous_character + current_character).equals("IV")){result += 3;}
                else if ((previous_character + current_character).equals("IX")){result += 8;}
                else if ((previous_character + current_character).equals("XL")){result += 30;}
                else if ((previous_character + current_character).equals("XC")){result += 80;}
                else if ((previous_character + current_character).equals("CD")){result += 300;}
                else if ((previous_character + current_character).equals("CM")){result += 800;}
                continue;
            }
            else{result += dictionary.get(current_character);}
        }
        return result;
    }
}