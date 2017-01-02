package Fundamental;

import java.util.Comparator;

/**
 * Created by Tao on 1/1/2017.
 */
public class Point2D implements Comparable<Point2D> {
    public static final Comparator<Point2D> X_ORDER = new XOrder();
    public static final Comparator<Point2D> Y_ORDER = new YOrder();
    public static final Comparator<Point2D> R_ORDER = new ROrder();

    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        if (Double.isInfinite(x) || Double.isInfinite(y)) {
            throw new IllegalArgumentException("Coordinates must be finite");
        }
        if (Double.isNaN(x) || Double.isNaN(y)) {
            throw new IllegalArgumentException("Coordinates cannot be Nan");
        }
        if (x == 0.0)
            this.x = 0.0;
        else
            this.x = x;
        if (y == 0.0)//convert -0.0 to +0.0
            this.y = 0;
        else
            this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return Math.sqrt(x * x + y * y);
    }

    public double theta() {
        return Math.atan2(y, x);
    }

    public double angleTo(Point2D that) {
        double dx = that.x - x;
        double dy = that.y - y;
        return Math.atan2(dy, dx);
    }

    public double distanceTo(Point2D that) {
        double dx = x - that.x;
        double dy = y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point (x1, y1)
     * if and only if either {@code y0 < y1} or if {@code y0 == y1} and {@code x0 < x1}.
     *
     * @param that the other point
     * @return the value {@code 0} if this string is equal to the argument
     * string (precisely when {@code equals()} returns {@code true});
     * a negative integer if this point is less than the argument
     * point; and a positive integer if this point is greater than the
     * argument point
     */
    public int compareTo(Point2D that) {
        if (y < that.y)
            return -1;
        if (y > that.y)
            return 1;
        if (x > that.x)
            return 1;
        if (x < that.x)
            return -1;
        return 0;
    }

//    public Comparable<Point2D> poloarOrder(){
//        return new PoloarOrder();
//    }

    public Comparator<Point2D> distanceToOrder() {
        return new DistanceToOrder();
    }

    private static class XOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.x > q.x)
                return 1;
            else if (p.x < q.x)
                return -1;
            else
                return 0;
        }
    }

    private static class YOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.y > q.y)
                return 1;
            else if (p.y < q.y)
                return -1;
            else
                return 0;
        }
    }

    private static class ROrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            double delta = (p.x * p.x + p.y * p.y) - (q.x * q.x + q.y * q.y);
            if (delta < 0)
                return -1;
            else if (delta > 0)
                return 1;
            else
                return 0;
        }
    }

    private class Atan2Order implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            double angle1 = angleTo(q);
            double angle2 = angleTo(q);
            if (angle1 < angle2)
                return -1;
            else if (angle1 > angle2)
                return 1;
            return 0;
        }
    }

    private class DistanceToOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            double dist1 = distanceTo(p);
            double dist2 = distanceTo(q);
            if (dist1 > dist2)
                return 1;
            else if (dist1 < dist2)
                return -1;
            else
                return 0;
        }
    }

    public boolean equals(Object other) {
        if (other == this)
            return true;
        else if (other == null)
            return false;
        if (other.getClass() != other.getClass())
            return false;
        Point2D that = (Point2D) other;
        return x == that.x && this.y == that.y;
    }

    //ccw cha ji
    //
    /*
    /**
     * Returns true if a→b→c is a counterclockwise turn.
     * @param a first point
     * @param b second point
     * @param c third point
     * @return { -1, 0, +1 } if a→b→c is a { clockwise, collinear; counterclocwise } turn.
     */

    //if chaji>0 then b is the clockwise direction of c;
    public static int ccw(Point2D a, Point2D b, Point2D c) {
        double area2 = (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
        if (area2 > 0)
            return 1;
        else if (area2 < 0)
            return -1;
        else
            return 0;
    }

    //line p1p1
    //line p3p4

    public double direction(Point2D p1, Point2D p2, Point2D p3) {
        return (p2.x - p1.x) * (p3.y - p1.y) - (p2.x - p1.x) * (p2.y - p1.y);
    }

    public boolean isOnSegement(Point2D p1, Point2D p2, Point2D p3) {
        if (p3.x <= Math.max(p1.x, p2.x) && p3.x >= Math.min(p1.x, p2.x) && p3.y >= Math.min(p2.y, p1.y) && p3.y <= Math.max(p2.y, p1.y))
            return true;
        return false;
    }

    public boolean segementIntersection(Point2D p1, Point2D p2, Point2D p3, Point2D p4) {
        double d1 = direction(p3, p4, p1);
        double d2 = direction(p3, p4, p1);
        double d3 = direction(p1, p2, p3);
        double d4 = direction(p1, p2, p4);
        if (((d1 < 0 && d2 > 0) || (d1 > 0 && d2 < 0)) && ((d3 < 0 && d4 > 0) || (d3 > 0 && d4 < 0)))
            return true;
        else if (d1 == 0 && isOnSegement(p3, p4, p1))
            return true;
        else if (d2 == 0 && isOnSegement(p3, p4, p2))
            return true;
        else if (d3 == 0 && isOnSegement(p1, p2, p3))
            return true;
        else if (d4 == 0 && isOnSegement(p1, p2, p4))
            return true;
        return false;
    }
}
