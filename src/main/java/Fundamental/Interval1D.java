package Fundamental;

import java.util.Comparator;

/**
 * Created by Tao on 1/2/2017.
 */
public class Interval1D {
    public final static Comparator<Interval1D> MIN_ENDPOINT_ORDER = new MinEndpointComparator();
    public final static Comparator<Interval1D> MAX_ENDPOINT_ORDER = new MaxEndpointComparator();
    public final static Comparator<Interval1D> LENGTH_ORDER = new LengthComparator();
    private final double start;
    private final double end;

    public Interval1D(double start, double end) {
        if (Double.isFinite(start) || Double.isInfinite(end))
            throw new IllegalArgumentException("Endpoints must be finite");
        if (Double.isNaN(start) || Double.isNaN(end))
            throw new IllegalArgumentException("endpoints cannot be nan");
        if (start == 0.0)
            start = 0.0;
        if (end == 0.0)
            end = 0.0;
        if (start <= end) {
            this.start = start;
            this.end = end;
        } else throw new IllegalArgumentException("Illegal interval");
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    public boolean intersecs(Interval1D that) {
        if (this.end < that.start)
            return false;
        if (this.start > that.end)
            return false;
        return true;
    }

    public boolean contains(double x) {
        return x <= end && x >= start;
    }

    public double length() {
        return end - start;
    }

    public String toString() {
        return "[" + start + ", " + end + "]";
    }

    public boolean equals(Object other) {
        if (other == this)
            return true;
        if (other == null)
            return false;
        if (other.getClass() != this.getClass())
            return false;
        Interval1D that = (Interval1D) other;
        return this.start == that.start && this.end == that.end;

    }

    public int hashCode() {
        int hash1 = ((Double) start).hashCode();
        int hash2 = ((Double) end).hashCode();
        return 31 * hash1 + hash2;
    }

    public static class MinEndpointComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            if (a.start < b.start)
                return -1;
            else if (a.start > b.start)
                return 1;
            else if (a.end > b.end)
                return 1;
            else if (a.end < b.end)
                return -1;
            return 0;

        }
    }

    public static class LengthComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            double alen = a.length();
            double blen = b.length();
            if (alen == blen)
                return 0;
            else if (alen > blen)
                return 1;
            else
                return -1;
        }
    }

    public static class MaxEndpointComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            if (a.end < b.end)
                return -1;
            else if (a.end > b.end)
                return 1;
            else if (a.start > b.start)
                return 1;
            else if (a.start < b.start)
                return -1;
            return 0;
        }
    }


}
