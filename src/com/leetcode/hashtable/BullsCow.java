package com.leetcode.hashtable;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dhaval on 7/28/2016.
 */
public class BullsCow {
    public String getHint(String secret, String guess) {

        Map<Character, List<Integer>> map = new HashMap<>();
        Map<Character, Integer> countMap = new HashMap<>();

        int len = secret.length();
        int glen = guess.length();
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i < len; i++) {
            if (!map.containsKey(secret.charAt(i))) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(secret.charAt(i), temp);
                countMap.put(secret.charAt(i), 1);
            }
            else {
                List<Integer> temp = map.get(secret.charAt(i));
                temp.add(i);
                map.put(secret.charAt(i), temp);
                countMap.put(secret.charAt(i), countMap.get(secret.charAt(i))+1);
            }
        }
        for (int i = 0; i < glen; i++) {
            char c = guess.charAt(i);
            if(map.containsKey(c)) {
                List<Integer> temp = map.get(c);
                if(temp.size() > 0 && temp.contains(i)){
                    bulls++;
                    temp.remove(new Integer(i));
                    map.put(c, temp);
                    countMap.put(c, countMap.get(c)-1);
                }
                else {
                    if (temp.size() > 0 && countMap.get(c) > 0){
                        cows++;
                        countMap.put(c, countMap.get(c)-1);
                    }
                }
            }
        }

        return bulls+"A"+cows+"B";
    }

    public static void main(String[] args) {
        System.out.println(new BullsCow().getHint("1122", "1222"));
    }

}
