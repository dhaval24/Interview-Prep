package com.leetcode.dynamic.self;

/**
 * Created by Dhaval on 8/17/2016.
 */
public class MinCostMatrixMul {


    public int findCost(int arr[]){
        int temp[][] = new int[arr.length][arr.length];
        for(int l=2; l < arr.length; l++){
            for(int i=0; i < arr.length - l; i++){
                int j = i + l;
                temp[i][j] = 1000000;
                for(int k=i+1; k < j; k++){
                    int q = temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j];
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
            }
        }
        return temp[0][arr.length-1];
    }

    public static void main(String[] args) {

        int[] dimension = {2, 3, 6, 4, 5};
        System.out.println(new MinCostMatrixMul().findCost(dimension));
    }
}
