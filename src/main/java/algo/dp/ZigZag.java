package algo.dp;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {


    class Node{
        int data;
        int up ;

        public Node(int data, int up) {
            this.data = data;
            this.up = up;
        }
    }
     List<List<Node>> lists = new ArrayList<>();

    void upDateList(List<Node> list,int data){
        if(list.get(list.size()-1).up==1&&list.get(list.size()-1).data<data||list.get(list.size()-1).up==-1&&list.get(list.size()-1).data>data){
            list.add(new Node(data,-list.get(list.size()-1).up));
        }
    }
    void setUpList(int[] arr,int n){
        List<List<Integer>> sol = new ArrayList<>();
        List<Node> initList = new ArrayList<>();
        initList.add(new Node(arr[0],0));
        this.lists.add(initList);
        sol.add(new ArrayList<>());
        sol.get(0).add(0);
        for(int i=1;i<n;i++){
            //basic case
            if(sol.get(i-1).size()==1&&lists.get(sol.get(i-1).get(0)).get(lists.get(sol.get(i-1).get(0)).size()-1).up!=1&&
                    lists.get(sol.get(i-1).get(0)).get(lists.get(sol.get(i-1).get(0)).size()-1).data<arr[i]||lists.get(sol.get(i-1).get(0)).get(lists.get(sol.get(i-1).get(0)).size()-1).up!=-1&&
                    lists.get(sol.get(i-1).get(0)).get(lists.get(sol.get(i-1).get(0)).size()-1).data>arr[i]){
                lists.get(sol.get(i-1).get(0)).add(new Node(arr[i],-lists.get(sol.get(i-1).get(0)).get(lists.get(sol.get(i-1).get(0)).size()-1).data));
                sol.add(new ArrayList<>());
                sol.get(i).add(sol.get(i).get(0));
                lists.add(new ArrayList<>());
                //lists.get(lists.size()-1).add(new )
            }
            else {
                //update prev sol
                for(int k=0;k< lists.size();k++){
                    upDateList(lists.get(k),arr[i]);
                }
            }
        }
    }
}
