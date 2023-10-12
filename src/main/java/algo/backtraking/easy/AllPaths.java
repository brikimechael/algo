package algo.backtraking.easy;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {
    static int[] moveX ={0,1};
    static int[] moveY = {1,0};
    static boolean isPossible(int i,int j,int n,int m){
        return i<=n && j<=m;
    }
    static boolean isDone(int i,int j,int n,int m){
        return i==n && j==m;
    }
    static void checkPoint(int n, int m, int i, int j, int[][] grid, List<Integer> tmp) {
        if (isDone(i, j, n, m)){
            tmp.add(0);
        }
        else {
            for (int k = 0; k < 2; k++) {
                if (isPossible( i + moveX[k], j + moveY[k],n, m)) {
                    tmp.add(grid[i + moveX[k]][ j + moveY[k]]);
                    checkPoint(n, m, i + moveX[k], j + moveY[k], grid, tmp);
                }
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n, int m, int[][] grid) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();


        return result;
    }

    public static void main(String... args){

        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> tmp = new ArrayList<>();
        checkPoint(1,1,0,0,grid,tmp);

        for(int i=0;i<tmp.size();i++){
           // if()
        }
        System.out.println("bla");
    }

}
