package com.leetcode.contest2;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by Dhaval on 8/27/2016.
 */
public class EleminationGame {

    public int lastRemaining(int n) {

        if (n == 1) return 1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        boolean flag = false;
        while(list.size() > 1) {

            if (flag == false) {
                removeFromFirst(list);
                flag = true;
            }
            else {
                removeFromEnd(list);
                flag = false;
            }

        }
        return list.get(0);
    }

    private void removeFromFirst(LinkedList<Integer> list) {

        int size = list.size();
        if (size % 2 == 0) {
            for (int i = 0; i < size/2; i++) {
                list.remove(i);
            }
        }
        else {
            for (int i = 0; i <= size/2; i++) {
                list.remove(i);
            }
        }


    }

    private void removeFromEnd(LinkedList<Integer> list) {

        int size = list.size();
        int size1 = size;
        if (size % 2 == 0) {
            for (int i = 0; i < size/2; i++) {
                list.remove(size1 - i - 1);
                size1--;
            }
        }
        else {
            for (int i = 0; i <= size/2; i++) {
                list.remove(size1 - i - 1);
                size1--;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new EleminationGame().lastRemaining(3922));
    }
}
