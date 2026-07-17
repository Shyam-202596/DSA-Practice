package dsa.linear_search;

import java.util.Arrays;

public class SearchInStrings {
    public static void main(String[] args) {
        String name = "Shyam";
        char target = 'y';
        //System.out.println(stringSearch(name, target));
        //System.out.println(stringSearch2(name, target));
        System.out.println(Arrays.toString(name.toCharArray()));
    }

    /**
     * Returns true if target exists in str by iterating over a char array copy.
     * Assumes str is non-null.
     */
    private static boolean stringSearch2(String str, char target) {
        if(str.isEmpty()) return false;

        for(char ch : str.toCharArray()){
            if(target == ch) return true;
        }

        return false;
    }

    /**
     * Returns true if target exists in str by checking each index with charAt.
     * Assumes str is non-null.
     */
    private static boolean stringSearch(String str, char target) {
        if(str.isEmpty()) return false;

        for(int i=0; i<str.length(); i++){
            if(target == str.charAt(i)) return true;
        }

        return false;
    }
}
