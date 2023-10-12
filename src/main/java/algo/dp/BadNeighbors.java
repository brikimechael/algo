package algo.dp;

public class BadNeighbors {


    int max(int[]grid,int n){
        int[] sol = new int[n];
        int[] firstIncluded = new int[n];
        int[] lastIncluded = new int[n];
        sol[0]=grid[0];
        firstIncluded[0]=1;
        lastIncluded[0]=1;
        for(int i=1;i<n;i++){
            int max = grid[i];
            lastIncluded[i]=-1;
            firstIncluded[i]=-1;
            //basic case

                int maxIndex=-1;
                for (int j = 0; j < i; j++) {
                    int tmp = sol[j];

                    if(j!=1&&j!=i-1&&i!=n-1){
                        tmp+=grid[i];
                        if(tmp>max) {
                            firstIncluded[i] = firstIncluded[j];
                            max=tmp;
                            maxIndex=j;
                        }
                    }
                    if(tmp>max){
                     max=tmp;
                     maxIndex=j;
                    }

                }
                if(maxIndex!=-1){
                    firstIncluded[i]=firstIncluded[maxIndex];

                }
                if(maxIndex!=-1&&max==sol[maxIndex]+grid[i]||max==grid[i]) {
                    lastIncluded[i] = 1;
                }

            sol[i]=max;
        }

        return sol[n-1];
    }


    public static void main(String...args){
        BadNeighbors badNeighbors = new BadNeighbors();
        int[] arr = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
        System.out.println(badNeighbors.max(arr,40));
    }
}
