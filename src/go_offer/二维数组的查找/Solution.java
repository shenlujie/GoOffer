package go_offer.二维数组的查找;


import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        int target = scanner.nextInt();
        System.out.print(Find(target,array));

    }


    public static boolean Find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (target == array[i][j]){
                    return true;
                }
            }

        }
        return false;
    }
}
