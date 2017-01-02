package Fundamental;

/**
 * Created by Tao on 1/1/2017.
 */
public class Counter implements Comparable<Counter> {
    private final String name;
    private int count = 0;

    public Counter(String id) {
        name = id;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return count + " " + name;
    }

    public int compareTo(Counter that) {
        if (count < that.count)
            return -1;
        else if (count > that.count)
            return 1;
        else
            return 0;
    }

}
