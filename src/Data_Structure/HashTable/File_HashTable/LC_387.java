package Data_Structure.HashTable.File_HashTable;

import java.util.HashMap;
import java.util.Map;

public class LC_387 {
    public static int firstUniqChar(String s) {
        Map<Character,Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (countMap.containsKey(c) == false) {
                countMap.put(c,1);
            } else {
                countMap.put(c,countMap.get(c) + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (countMap.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        System.out.println(firstUniqChar(s1));
    }
}
