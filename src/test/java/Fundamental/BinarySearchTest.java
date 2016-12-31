package Fundamental;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Tao on 12/31/2016.
 */
public class BinarySearchTest {

    public BinarySearch binarySearch=null;
    @Before
    public void setUp() throws Exception {
        binarySearch=new BinarySearch();
    }

    @Test
    public void testIndexOf() throws Exception {

        int []nums={1,2,3,4,5,6};
        int index = binarySearch.indexOf(nums, 6);
        assertEquals(index, 5);
    }
}