package Fundamental;

import java.util.Random;

/**
 * Created by Tao on 1/2/2017.
 */
public class Accumulator {
    private int n = 0;//numbe of data values
    private double sum = 0.0;//sample variance*(n-1)
    private double mu = 0.0;//smaple mean

    public Accumulator() {

    }

    public void addDataValue(double x) {
        n++;
        double delta = x - mu;
        mu += delta / n;
        sum += (double) (n - 1) / n * delta * delta;
    }

    public double mean() {
        return mu;
    }

    public double var() {
        if (n <= 1)
            return Double.NaN;
        return sum / (n - 1);
    }

    public double stddev() {
        return Math.sqrt(this.var());
    }

    public int count() {
        return n;
    }
}
