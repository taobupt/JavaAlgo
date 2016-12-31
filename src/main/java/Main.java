


import Fundamental.BinarySearch;
import org.apache.commons.lang3.*;
import java.util.*;

/**
 * Created by Tao on 12/31/2016.
 */
public class Main {
    public static void main(String []args){
        int []nums={-6,-5,-4,-3,-1,4,5,8};
        Arrays.sort(nums);
        Integer []num=ArrayUtils.toObject(nums);
        Arrays.sort(num, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        for(Integer x:num)
            System.out.println(x);


        BinarySearch s=new BinarySearch();
        System.out.println(s.indexOf(nums,-3));
    }
}
