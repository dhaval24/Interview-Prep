package com.leetcode.arrays;

/**
 * Created by Dhaval on 9/24/2016.
 */
public class RotateImage {

    public void rotateImage(int[][] image) {

        int n = image.length;

        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {

                int offSet = i - first;

                //Save top
                int top = image[first][i];
                //left -> top
                image[first][i] = image[last-offSet][first];
                //bottom -> left
                image[last-offSet][first] = image[last][last-offSet];
                //right -> bottom
                image[last][last-offSet] = image[i][last];
                //top -> right
                image[i][last] = top;


            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        new RotateImage().rotateImage(arr);
    }
}
