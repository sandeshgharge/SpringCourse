package morganStanleyTest;

import java.util.HashMap;
import java.util.HashSet;

public class StringTest {

    public static void main(String[] args){

        String s1 = "Integral";
        String s2 = "Angle has three sides";
        String res = "";

        /**
         * Anagram - same alphabets, same length but different words
         */

        HashMap<String, Integer> strHashMap1 = new HashMap<String, Integer>();

        for (char c : s1.toCharArray()) {
            Integer temp = strHashMap1.get(String.valueOf(c));
            if(temp == null) temp = 0;
            strHashMap1.put(String.valueOf(c).toLowerCase(), ++temp);

        }

        /**
        strHashMap1.forEach((c, i) -> {
            System.out.println(c);
            System.out.println(i);
        });*/

        for(char c: s2.toCharArray()){
            String strTemp = String.valueOf(c).toLowerCase();

            if(strHashMap1.containsKey(strTemp)){
                Integer temp = strHashMap1.get(strTemp);
                if(temp == 0){

                }
                else{
                    strHashMap1.put(strTemp, --temp);
                    res = res + strTemp;
                }
            }
        }

        System.out.println(res);
    }
}
