package algo.dp;

import java.util.ArrayList;

public class Basic {

    final int count = 20;

    // sequence sum
    int minSum(int[] v,int s){
        int[] sol = new int[s+1];
        for(int i=0;i<=s;i++){
            int tmp=Integer.MAX_VALUE;
            boolean found = false;
            for(int j=0;j<v.length;j++){
                if(v[j]<=i && tmp>sol[i-v[j]]){
                    found = true;
                    tmp=sol[i-v[j]];
                }
            }
            if(!found)
                sol[i]=0;
            else
            sol[i]=tmp+1;
        }
        return sol[s];
    }

    //longest non-decreasing seq numb noob way :(
    int longNonDec(int[] v,int n){
        int[] sol = new int[n];
        int[] leastMax = new int[n];
        for(int i=1;i<n;i++){
            int tmp=1;

                if(v[i]>leastMax[i-1]&&sol[i-1]+1>tmp){
                    tmp=sol[i-1]+1;
                }

            sol[i]=tmp;
        }

        return sol[n-1];
    }

    // good one
    int nonDecSeqNum(int []v ,int n){
        int[] sol = new int[n];
        int[] seq = new int[n+1];
        sol[0]=1;
        seq[1]=v[0];
        for(int i=1;i<n;i++){
            //basic case
            if(v[i]>seq[sol[i-1]]){
                sol[i]=sol[i-1]+1;
                seq[sol[i-1]+1]=v[i];
            }
            // update prev seq
            else {
                for(int j=1;j<=i;j++){
                    if(v[i]<seq[j]){
                        seq[j]=v[i];
                        break;
                    }
                }
                sol[i]=sol[i-1];
            }
        }


        return sol[n-1];
    }
    class Node{
        int destination,weight;
    }
    int minDistance(ArrayList<ArrayList<Node>> adj,int n){
        int[] dist = new int[n];
        dist[0]=0;
        for(int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE/n;
        }
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                if(dist[adj.get(i).get(j).destination]>dist[i]+adj.get(i).get(j).weight){
                    dist[adj.get(i).get(j).destination]=dist[i]+adj.get(i).get(j).weight;
                }
            }
        }
        return dist[n];
    }


    public static void main(String[] args){
        Basic basic = new Basic();
        int[] v = {6 ,3 ,7, 4, 6, 9};

        //System.out.println(basic.minSum(v,10));
        System.out.println(basic.nonDecSeqNum(v,6));
    }
}
