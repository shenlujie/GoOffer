package go_offer.顺时针打印矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1  2  3  4
 *                            5  6  7  8
 *                            9  10 11 12
 *                            13 14 15 16
 * 则依次打印出数字   1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @create: 2018/12/16
 * @Author: SLJ
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0){
            return null;
        }

        //定义四个变量，上，下，左，右
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0;
        int left = 0;
        int right = col - 1;
        int bottom = row - 1;
        //左上角和右下角两个点沿对角线向中心靠拢
        while (left <= right && top <= bottom){

            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if (top != bottom){
                for (int i = right - 1; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }
            if (left != right){
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }

            left ++;
            bottom --;
            right --;
            top ++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        List<Integer> list = new Solution().printMatrix(arr);
        for (Integer i  :list ) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
