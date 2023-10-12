package algo.graph.shortest;

import java.util.ArrayList;
import java.util.List;

public class MinPath {
    public static void setUpList(List<Integer>list,int[]prev,int index){
        if(index==-1)
            ;
        else{
            setUpList(list,prev,prev[index]);
            list.add(index);
        }
    }
    public  List<Integer> shortestPath(int n, int m, int edge[][]) {
        List<Integer> result = new ArrayList<>();
        int[] prev = new int[n+1];
        int[] dist = new int[n+1];
        for(int i=0;i<n+1;i++){
            prev[i]=-1;
            dist[i]=Integer.MAX_VALUE/n;
        }
        dist[0]=0;
        for(int i =0;i<n;i++){
            for(int k=0;k<m;k++){


                if(dist[edge[k][0]-1]>dist[edge[k][1]-1]+edge[k][2]){
                    dist[edge[k][0]-1]=dist[edge[k][1]-1]+edge[k][2];

                    prev[edge[k][0]]=edge[k][1];
                }
                if(dist[edge[k][1]-1]>dist[edge[k][0]-1]+edge[k][2]){
                    dist[edge[k][1]-1]=dist[edge[k][0]-1]+edge[k][2];

                    prev[edge[k][1]]=edge[k][0];
                }



            }
        }
        if(dist[n-1]==Integer.MAX_VALUE/n){
            result.add(-1);
        }
        else{
            setUpList(result,prev,n);
        }
        return result;
    }

    static void swap(int i,int j,int [] arr,int[] dep){
        int tmpArr = arr[i];
        int tmpDep = dep[i];
        arr[i]=arr[j];
        dep[i]=dep[j];
        arr[j]=tmpArr;
        dep[j]=tmpDep;
    }

    static void sort(int []arr,int[]dep,int n){
        boolean sorted = false;
        while (!sorted){
            sorted=true;
            for(int i=0;i<n-1;i++){
                if(arr[i]>arr[i+1]){
                    sorted=false;
                    swap(i,i+1,arr,dep);
                }
            }
        }
    }
    static int findPlatform(int arr[], int dep[], int n) {
        // sort array
        // find congestion

        sort(arr, dep, n);
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i + 1;
            int minI=i+1;
            int found=-1;
            //find min arr time ?
            for (int j = i + 1; j < n; j++) {
                if(arr[j]<arr[minI]){
                    minI=j;
                }
                if (arr[j] >= dep[i]) {
                    if(found==-1||arr[j] <= arr[minIndex]) {
                        minIndex = j;
                        found=1;
                    }

                }


            }
            if(found!=-1)
            swap(minIndex, i + 1, arr, dep);
            else
                swap(minI,i+1,arr,dep);
        }
        int res = 1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] <= dep[i]) {
                res++;
            }
        }
        return res;

        }


    public static void main(String... args){
        int arr[]= {900, 1800, 950, 1100, 1500, 940};
        int dep[]= {910, 2000, 1120, 1130, 1900, 1200};
        /*int[][] edge ={{1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}};
        MinPath minPath = new MinPath();
        minPath.shortestPath(5,6,edge);*/
        System.out.println(MinPath.findPlatform(arr,dep,6));
    }
}
