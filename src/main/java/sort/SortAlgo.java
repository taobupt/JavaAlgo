package sort;

/**
 * Created by tao on 3/12/17.
 */
public class SortAlgo {


    //lint code sort color
    public void countSort(int []A,int k){
        int []res=new int[k+1];
        for(int x:A)
            res[x]++;
        for(int i=1;i<=k;++i){
            res[i]+=res[i-1];
        }
        int []ans=A.clone();
        int n=A.length;
        for(int i=n-1;i>=0;--i){
            ans[--res[A[i]]]=A[i];
        }
        A=ans.clone();
    }
}
