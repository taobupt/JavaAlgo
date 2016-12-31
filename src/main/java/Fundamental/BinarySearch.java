package Fundamental;

/**
 * Created by Tao on 12/31/2016.
 */
public class BinarySearch {
    public BinarySearch(){

    }

    //iterative way
    public int indexOf(int []nums,int key){
        int end=nums.length-1,begin=0,mid=0;
        while(begin<end){
            mid=(end-begin)/2+begin;
            if(nums[mid]==key)
                return mid;
            else if(nums[mid]>key)
                end=mid;
            else
                begin=mid+1;
        }
        return nums[begin]==key?begin:-1;
    }

    //you can also write the
}
