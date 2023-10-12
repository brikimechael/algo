package algo.dp.easy;

public class BookSeq {
    int max_Books(int a[], int n, int k)
    {
        int[] sol = new int[n];
        int[] lastIndex = new int[n];

        if(a[0]<=k)
            sol[0]=a[0];
        else
            sol[0]=0;
        lastIndex[0]=0;
        for(int i=0;i<n-1;i++){
            if(a[i+1]<=k){
                if(lastIndex[i]==i){
                    sol[i+1]=sol[i]+a[i+1];
                    lastIndex[i+1]=i+1;
                }else{
                    int s = a[i+1];
                    int j =i;
                    while (a[j]<=k&&j>=0){
                        s+=a[j];
                        j--;
                    }
                    if(s>sol[i]){
                        sol[i+1]=s;
                        lastIndex[i+1]=i+1;
                    }
                    else{
                        lastIndex[i+1]=lastIndex[i];
                        sol[i+1]=sol[i];
                    }
                }
            }
            else {
                lastIndex[i+1]=lastIndex[i];
                sol[i+1]=sol[i];
            }
        }


        return sol[n-1];
    }

    public static void main(String... args){
        BookSeq bookSeq = new BookSeq();
        int[]a = {3 ,2 ,400 ,100 ,400 ,1 ,1 ,3};
        System.out.println(bookSeq.max_Books(a,8,100));
    }
}
