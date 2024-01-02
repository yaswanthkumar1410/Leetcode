import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> mapT = new HashMap();
        for(char c : t.toCharArray()){
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = Integer.MAX_VALUE, i = 0, j = 0, minLength = s.length(), count = mapT.size();
        boolean found= false;

        while(j < s.length()){
            char charAtJ = s.charAt(j++);
            if(mapT.containsKey(charAtJ)){
                mapT.put(charAtJ, mapT.get(charAtJ) - 1);
                if(mapT.get(charAtJ) == 0) count--;
            }

            if(count > 0) continue;

            while(count == 0){
                char charAtI = s.charAt(i++);
                if(mapT.containsKey(charAtI)){
                    mapT.put(charAtI, mapT.get(charAtI) + 1);
                    if(mapT.get(charAtI) >0) count++;
                }
            }

            if(j - i < minLength){
                minLength = j - i;
                left = i - 1;
                right = j;
                found = true;
            }
        }

        return found ? s.substring(left, right) : "";
    }
    public static void main(String[] args){
        System.out.println(minWindow("AaAAbcaab", "ab"));
    }
}

