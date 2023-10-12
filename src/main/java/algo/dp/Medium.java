package algo.dp;

public class Medium {

    int getSol(int[][]sol,int i,int j){
        if(i<0||j<0){
            return 0;
        }
        else
            return sol[i][j];
    }
    int getMax(int a,int b){
        return a>b?a:b;
    }
    int maxPath(int[][] grid,int n,int m){
        int[][] sol = new int[n][m];
        sol[0][0]=grid[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sol[i][j]=grid[i][j]+getMax(getSol(sol,i-1,j),getSol(sol,i,j-1));
            }
        }
        return sol[n-1][m-1];
    }

    public static void main(String... args){
        Medium medium = new Medium();
        int[][] grid ={{1,1,1},{0,10,1},{0,0,1}};
        System.out.println(medium.maxPath(grid,3,3));
    }
}
