package algo.search;


public class Search {

    static int binaryRecursive(int[]arr,int l,int r,int val ) {
        if (l <= r) {
            if(arr[l]>val || arr[r]<val){
                return -1;
            }
            if (val < arr[(l + r) / 2]) {
                return binaryRecursive(arr, l, (l + r) / 2 - 1, val);
            }
            if (val > arr[(l + r) / 2]) {
                return binaryRecursive(arr, (l+r)/2+1, r, val);
            }
            else{
                return (l+r)/2;
            }
        }
        return -1;
    }






    static int binary(int[] arr,int val){
        int l=0,r = arr.length-1;

        while(l<=r){
            if(arr[l]>val || arr[r]<val){
                return -1;
            }
            int mid = (l+r)/2;
            if(arr[mid]==val){
                return mid;
            }
            if(arr[mid]>val){
                r=mid-1;
            }
            if(arr[mid]<val){
                l=mid+1;
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binary(new int[]{1,2,3,4,5},1));
        System.out.println(binaryRecursive(new int[]{1,2,3,4,5},0,4,1));


    }
}
