package Fundamental;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Tao on 12/31/2016.
 */
public class Average {
    public Average() {

    }

    public void getAverageFromConsole() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double sum = 0;
        while (scanner.hasNext()) {
            double x = scanner.nextDouble();
            sum += x;
            //  System.out.println(x);
            count++;
        }

        System.out.println(sum / count);
    }
}
