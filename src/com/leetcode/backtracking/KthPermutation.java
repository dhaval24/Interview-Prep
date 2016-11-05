package com.leetcode.backtracking;

import java.util.LinkedList;

/**
 * Created by Dhaval on 8/23/2016.
 * Algorithm: The intuition is that suppose you have number n = 4 and k =14th then you have 4 prime groups:
 *  1 + perm(2,3,4)
 *  2 + perm(1,3,4)
 *  3 + perm(1,2,4)
 *  4 + perm(1,2,3)
 *  each is a set of 6. So 14th permutation lies in group 3. So our first number is 3. Now problem narrows down
 *  to 1 + perm(2,4)
 *  2 + perm(1,4)
 *  4 + perm(1,2)
 *  Now k will not remain 14 we need to update that.
 *
 *  This all is done programatically as : We maintain a LinkedList of indexes fron 1 - n. We calculate n!.
 *  Now to get the index of the numbers it is k-1/(n - 1)!. We take K-1 because indexes are started from 0.
 *  We add the element at index into the string builder and remove the same element from the string to get
 *  the permutation of the remaining.
 *  K is updated as k - currentIndex * (n-i)! where i starts from 0 to n-1.
 *
 */
public class KthPermutation {

    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> num = new LinkedList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++ ) {
            fact *= i;
            num.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n-i);
            int index = l/fact;
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new KthPermutation().getPermutation(4, 14));
    }
}
