package sort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tao on 3/12/17.
 */
public class SortAlgoTest {

    SortAlgo sa=null;

    @Before
    public void setup(){
        sa=new SortAlgo();
    }
    @Test
    public void countSort() throws Exception {
        int []nums={2,5,3,0,2,3,0,3};
        sa.countSort(nums,5);
        for(int x:nums)
            System.out.println(x);
    }

}