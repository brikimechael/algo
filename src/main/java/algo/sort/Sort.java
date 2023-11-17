package algo.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort {

    // insertion,selection,bubbleSort

    void bubbleSort(int[] arr){

        boolean sorted = false;

        while(!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    sorted = false;
                }
            }
        }
    }

    // select minIndex at each iteration
    //O(n^2) time
    void insertionSort(int[] arr){

    int i = 0;

    while(i<arr.length-1){
        int minIndex=i;

        for(int j=i+1;j<arr.length;j++){
            if(arr[j]<arr[minIndex]){
                minIndex=j;
            }
        }
        int tmp = arr[i];
        arr[i]=arr[minIndex];
        arr[minIndex]=tmp;
    }

    }


    void selectionSort(int[] arr){

    }



    void mergeSort(int[] arr,int l,int r){

    if(l<r) {
        int m = (r+l)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l,m, r);
    }
    }


    void merge(int[]arr,int l,int m,int r){

        int [] left = new int[m-l+1];
        int [] right = new int[r-m];

        for(int i=0;i<m-l+1;++i){
            left[i]=arr[l+i];
        }
        for(int i=0;i<r-m;++i){
            right[i]=arr[m+1+i];
        }
        int i=0,j=0,k=l;

        while(i<m-l+1&j<r-m){
            if(right[j]>left[i]){
                arr[k]=left[i];
                i++;
            }else{
                arr[k]=right[j];
                j++;
            }
            k++;
        }

            while(i<m-l+1){
                arr[k]=left[i];
                i++;
                k++;
        }
        while(j<r-m){
            arr[k]=right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = new int[] {5,4,2,1,8,6,1};
       sort.mergeSort(arr,0,6);
        for(int i=0;i<7;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(       "ddd".substring(0,0));
        System.out.println(0.1+0.2);


    }
}
