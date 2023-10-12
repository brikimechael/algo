package algo.dp.easy;

public class PathWays {

    public static int ways(int n, int m)
    {
        int[][] sol = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for (int j=0;j<=m;j++){
                int s =0;
                if(i-1>=0)
                    s+=sol[i-1][j];
                if(j-1>=0)
                    s+=sol[i][j-1]%1000000007;

                sol[i][j]=i==0&&j==0?1:s%1000000007;
            }
        }

        return sol[n][m];
    }

    public static void main(String... args){
        System.out.println(ways(252,297));
    }
}
