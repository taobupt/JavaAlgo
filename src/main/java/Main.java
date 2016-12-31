


import Fundamental.Average;
import Fundamental.BinarySearch;
import Fundamental.Concate;
import org.apache.commons.lang3.*;
import java.util.*;

/**
 * Created by Tao on 12/31/2016.
 */
public class Main {
    public static void main(String []args){
        Concate conca=new Concate();
        String[]filenames={"A:\\log1.txt","A:\\log2.txt","A:\\log3.txt"};
        String des="A:\\log.txt";
        conca.concate(filenames,des);
        System.out.println(System.getProperty("line.separator"));
    }

}
